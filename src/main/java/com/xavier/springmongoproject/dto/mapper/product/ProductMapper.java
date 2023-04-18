package com.xavier.springmongoproject.dto.mapper.product;

import com.xavier.springmongoproject.domain.product.Product;
import com.xavier.springmongoproject.dto.model.product.ProductDto;

import java.util.List;

public interface ProductMapper {
    ProductDto map(Product source);
    List<ProductDto> map(List<Product> sources);
}
