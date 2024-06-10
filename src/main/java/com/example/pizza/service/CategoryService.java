package com.example.pizza.service;

import com.example.pizza.model.Category;
import com.example.pizza.request.category.CategoryCreateRequest;
import com.example.pizza.request.category.CategoryUpdateRequest;

import java.util.List;


public interface CategoryService {

    Category create(CategoryCreateRequest categoryCreateRequest);

    Category update(CategoryUpdateRequest categoryUpdateRequest);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

}