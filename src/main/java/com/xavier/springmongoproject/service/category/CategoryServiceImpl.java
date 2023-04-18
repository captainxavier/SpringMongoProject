package com.xavier.springmongoproject.service.category;

import com.xavier.springmongoproject.domain.category.Category;
import com.xavier.springmongoproject.dto.mapper.category.CategoryMapper;
import com.xavier.springmongoproject.dto.model.category.CategoryDto;
import com.xavier.springmongoproject.repository.category.CategoryRepository;
import com.xavier.springmongoproject.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final ObjectValidator<CategoryDto> validator;
    private final CategoryMapper mapper;

    @Override
    public String save(CategoryDto categoryDto) {
        var validations = validator.validate(categoryDto);
        if (!validations.isEmpty()) {
            return String.join("\n", validations);
        }
        var category = Category
                .builder()
                .name(categoryDto.getName())
                .build();
        return String.format("Product %s created successful", repository.save(category).getId());
    }

    @Override
    public CategoryDto findCategoryById(String id) {
        var category = repository.findById(id).orElse(null);
        return mapper.map(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        return mapper.map(repository.findAll());
    }

    @Override
    public void delete(String id) {

    }
}
