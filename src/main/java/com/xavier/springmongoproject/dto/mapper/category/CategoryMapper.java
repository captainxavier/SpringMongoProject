package com.xavier.springmongoproject.dto.mapper.category;

import com.xavier.springmongoproject.domain.category.Category;
import com.xavier.springmongoproject.dto.model.category.CategoryDto;

import java.util.List;

public interface CategoryMapper {
    CategoryDto map(Category source);
    List<CategoryDto> map(List<Category> sources);
}
