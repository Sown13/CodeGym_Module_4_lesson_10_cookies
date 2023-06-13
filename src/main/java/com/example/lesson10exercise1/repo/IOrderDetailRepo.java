package com.example.lesson10exercise1.repo;

import com.example.lesson10exercise1.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}
