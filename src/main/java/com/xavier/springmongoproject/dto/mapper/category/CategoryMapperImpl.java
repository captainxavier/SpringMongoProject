package com.xavier.springmongoproject.dto.mapper.category;

import com.xavier.springmongoproject.domain.category.Category;
import com.xavier.springmongoproject.dto.model.category.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDto map(Category source) {
        return CategoryDto
                .builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

    @Override
    public List<CategoryDto> map(List<Category> sources) {
        return sources
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
