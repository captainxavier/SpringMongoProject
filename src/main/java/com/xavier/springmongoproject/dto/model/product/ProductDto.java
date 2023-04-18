package com.xavier.springmongoproject.dto.model.product;

import com.xavier.springmongoproject.domain.category.Category;
import com.xavier.springmongoproject.dto.model.category.CategoryDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String id;
    @NotEmpty(message = "Product name cannot be empty!")
    @NotNull(message = "Product name cannot be empty!")
    private String name;
    private String description;
    private List<String> tags;
    private CategoryDto categoryDto;
}
