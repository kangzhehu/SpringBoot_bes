package com.example.bes.service.impl;

import com.example.bes.entity.Product;
import com.example.bes.mapper.ProductMapper;
import com.example.bes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectProductByname(String name) {
        return productMapper.selectProductByName(name);
    }
}
