package com.xavier.springmongoproject.service;

import com.xavier.springmongoproject.domain.product.Product;

import java.util.List;

public interface ProductService {
    String save(Product product);
    Product findById(String id);
    List<Product> findAll();
    void delete(String id);
}
