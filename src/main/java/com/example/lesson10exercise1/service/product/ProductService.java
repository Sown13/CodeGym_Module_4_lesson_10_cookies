package com.example.lesson10exercise1.service.product;

import com.example.lesson10exercise1.model.Product;
import com.example.lesson10exercise1.repo.IProductRepository;
import com.example.lesson10exercise1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}