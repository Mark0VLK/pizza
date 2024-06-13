package com.example.pizza.mapper;

import com.example.pizza.model.Category;
import com.example.pizza.request.category.CategoryCreateRequest;
import com.example.pizza.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category createRequestToCategory(CategoryCreateRequest categoryCreateRequest);
    CategoryResponse categoryToResponse(Category category);
    List<CategoryResponse> categoriesToResponses(List<Category> categories);
    @Mapping(target = "id", source = "categoryId")
    Category toEntity(Long categoryId);
}
