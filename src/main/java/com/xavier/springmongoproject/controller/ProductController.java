package com.xavier.springmongoproject.controller;

import com.xavier.springmongoproject.domain.product.Product;
import com.xavier.springmongoproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;


    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> findById(@PathVariable("product_id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("product_id") String id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }


}
