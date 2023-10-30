package com.example.bes.service;

import com.example.bes.entity.Product;

public interface ProductService {
    Product selectProductByname(String name);
}
