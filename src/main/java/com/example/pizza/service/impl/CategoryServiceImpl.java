package com.example.pizza.service.impl;

import com.example.pizza.model.Category;
import com.example.pizza.request.category.CategoryCreateRequest;
import com.example.pizza.request.category.CategoryUpdateRequest;
import com.example.pizza.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public Category create(CategoryCreateRequest categoryCreateRequest) {

        return null;
    }

    @Override
    public Category update(CategoryUpdateRequest categoryUpdateRequest) {

        return null;
    }

    @Override
    public Category getCategoryById(Long id) {

        return null;
    }

    @Override
    public List<Category> getAllCategories() {

        return null;
    }
}
