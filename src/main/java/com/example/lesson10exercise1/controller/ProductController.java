package com.example.lesson10exercise1.controller;

import com.example.lesson10exercise1.model.Cart;
import com.example.lesson10exercise1.model.OrderDetail;
import com.example.lesson10exercise1.model.Product;
import com.example.lesson10exercise1.service.IOrderDetailService;
import com.example.lesson10exercise1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IOrderDetailService orderDetailService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @PostMapping("/thanhtoan")
    public ModelAndView thanhtoan(@ModelAttribute("cart") Cart cart ){
        ModelAndView modelAndView = new ModelAndView("/shop");
        OrderDetail orderDetail = new OrderDetail();
        List<Product> productList = new ArrayList<>();
        productList.addAll(cart.getProducts().keySet());
        orderDetail.setProductList(productList);
        orderDetail.setTotalPrice(cart.countTotalPayment());
        orderDetailService.save(orderDetail);
        return modelAndView;
    }
}