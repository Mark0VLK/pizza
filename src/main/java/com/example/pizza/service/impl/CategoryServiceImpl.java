package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.mapper.CategoryMapper;
import com.example.pizza.model.Category;
import com.example.pizza.repositories.CategoryRepository;
import com.example.pizza.request.category.CategoryCreateRequest;
import com.example.pizza.request.category.CategoryUpdateRequest;
import com.example.pizza.response.CategoryResponse;
import com.example.pizza.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse deleteById(Long id, DeleteMode deleteMode) {
        Category category = categoryRepository.findById(id).orElse(null);
        switch (deleteMode) {
            case HARD -> categoryRepository.deleteById(id);
            case SOFT -> {
                if (category != null) {
                    category.setIsDeleted(true);
                    categoryRepository.save(category);
                }
            }
        }
        return categoryMapper.categoryToResponse(category);
    }

    @Override
    public CategoryResponse create(CategoryCreateRequest categoryCreateRequest) {
        Category category = categoryMapper.createRequestToCategory(categoryCreateRequest);
        categoryRepository.save(category);
        return categoryMapper.categoryToResponse(category);
    }

    @Override
    public CategoryResponse update(Long id, CategoryUpdateRequest categoryUpdateRequest) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(categoryUpdateRequest.name());
            categoryRepository.save(category);
        }
        return categoryMapper.categoryToResponse(category);
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return categoryMapper.categoryToResponse(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.categoriesToResponses(categories);
    }
}
