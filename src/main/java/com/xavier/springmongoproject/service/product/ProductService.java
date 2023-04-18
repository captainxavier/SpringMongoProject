package com.xavier.springmongoproject.service.product;

import com.xavier.springmongoproject.dto.model.product.ProductDto;

import java.util.List;

public interface ProductService {
    String save(ProductDto productDto);
    ProductDto findById(String id);
    List<ProductDto> findAll();
    void delete(String id);
}
