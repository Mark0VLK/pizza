package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.CategoryCreateRequest;
import com.example.pizza.response.CategoryResponse;
import com.example.pizza.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public CategoryResponse deleteById(Long id, DeleteMode deleteMode) {

        return null;
    }

    @Override
    public CategoryResponse create(CategoryCreateRequest categoryCreateRequest) {

        return null;
    }

    @Override
    public CategoryResponse update(Long Id, CategoryCreateRequest categoryCreateRequest) {

        return null;
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {

        return null;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {

        return null;
    }
}
