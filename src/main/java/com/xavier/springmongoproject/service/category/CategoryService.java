package com.xavier.springmongoproject.service.category;

import com.xavier.springmongoproject.dto.model.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    String save(CategoryDto categoryDto);
    CategoryDto findCategoryById(String id);
    List<CategoryDto> findAll();
    void delete(String id);
}
