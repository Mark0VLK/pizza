package com.example.pizza.mapper;

import com.example.pizza.model.Category;
import com.example.pizza.request.category.CategoryCreateRequest;
import com.example.pizza.response.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    Category createRequestToCategory(CategoryCreateRequest categoryCreateRequest);
    CategoryResponse categoryToResponse(Category category);
    List<CategoryResponse> categoriesToResponses(List<Category> categories);
}
