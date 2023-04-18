package com.xavier.springmongoproject.service.product;

import com.xavier.springmongoproject.domain.product.Product;
import com.xavier.springmongoproject.dto.mapper.category.CategoryMapper;
import com.xavier.springmongoproject.dto.mapper.product.ProductMapper;
import com.xavier.springmongoproject.dto.model.product.ProductDto;
import com.xavier.springmongoproject.repository.category.CategoryRepository;
import com.xavier.springmongoproject.repository.product.ProductRepository;
import com.xavier.springmongoproject.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ObjectValidator<ProductDto> validator;
    private final ProductMapper productMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public String save(ProductDto productDto) {
        var validations = validator.validate(productDto);
        if (!validations.isEmpty()) {
            return String.join("\n", validations);
        }
        var category = categoryRepository.findById(productDto.getCategoryDto().getId()).orElse(null);
        var product = Product
                .builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .category(category)
                .build();
        return String.format("Product %s created successful", productRepository.save(product).getId());
    }

    @Override
    public ProductDto findById(String id) {
        var product = productRepository.findById(id).orElse(null);
        return productMapper.map(product);
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.map(productRepository.findAll());
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
