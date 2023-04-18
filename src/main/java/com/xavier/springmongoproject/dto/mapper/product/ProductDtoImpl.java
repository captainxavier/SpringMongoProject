package com.xavier.springmongoproject.dto.mapper.product;

import com.xavier.springmongoproject.domain.product.Product;
import com.xavier.springmongoproject.dto.model.category.CategoryDto;
import com.xavier.springmongoproject.dto.model.product.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ProductDtoImpl implements ProductMapper {

    @Override
    public ProductDto map(Product source) {
        var categoryDto = CategoryDto
                .builder()
                .id(source.getId())
                .name(source.getName())
                .build();

        return ProductDto
                .builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .tags(source.getTags())
                .categoryDto(categoryDto)
                .build();
    }

    @Override
    public List<ProductDto> map(List<Product> sources) {
        return sources
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
