package com.xavier.springmongoproject.service;

import com.xavier.springmongoproject.domain.product.Product;
import com.xavier.springmongoproject.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public String save(Product product) {
        //todo user a DTO
        //todo validate the objects
        return productRepository.save(product).getId();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
