package com.example.lesson10exercise1.service;

import com.example.lesson10exercise1.model.OrderDetail;
import org.springframework.stereotype.Service;

public interface IOrderDetailService {
    public void save(OrderDetail orderDetail);
}
