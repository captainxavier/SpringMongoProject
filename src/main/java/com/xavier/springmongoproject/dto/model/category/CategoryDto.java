package com.xavier.springmongoproject.dto.model.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CategoryDto {
    private String id;
    @NotNull(message = "Name cannot be null!")
    @NotEmpty(message = "Category Name cannot be empty!")
    private String name;
}
