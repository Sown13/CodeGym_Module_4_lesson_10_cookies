package com.example.lesson10exercise1.service.orderdetail;

import com.example.lesson10exercise1.model.OrderDetail;
import com.example.lesson10exercise1.repo.IOrderDetailRepo;
import com.example.lesson10exercise1.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepo orderDetailRepo;
    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepo.save(orderDetail);
    }
}
