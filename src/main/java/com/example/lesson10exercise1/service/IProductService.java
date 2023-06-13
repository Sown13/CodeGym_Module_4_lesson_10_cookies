package com.example.lesson10exercise1.service;

import com.example.lesson10exercise1.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}