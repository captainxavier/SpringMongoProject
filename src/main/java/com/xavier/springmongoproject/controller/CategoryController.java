package com.xavier.springmongoproject.controller;

import com.xavier.springmongoproject.dto.model.category.CategoryDto;
import com.xavier.springmongoproject.dto.model.product.ProductDto;
import com.xavier.springmongoproject.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(service.save(categoryDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("category_id") String id) {
        return ResponseEntity.ok(service.findCategoryById(id));
    }

}
