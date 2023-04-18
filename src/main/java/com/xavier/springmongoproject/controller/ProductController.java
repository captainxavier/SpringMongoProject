package com.xavier.springmongoproject.controller;

import com.xavier.springmongoproject.dto.model.product.ProductDto;
import com.xavier.springmongoproject.service.product.ProductService;
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
    public ResponseEntity<String> save(@RequestBody ProductDto product) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("product_id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("product_id") String id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }


}
