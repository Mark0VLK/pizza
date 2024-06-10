package com.example.pizza.service;

import com.example.pizza.model.Category;
import com.example.pizza.request.category.CategoryCreateRequest;
import com.example.pizza.request.category.CategoryUpdateRequest;

import java.util.List;


public interface CategoryService {

    /**
     * Creates a new category.
     *
     * @param categoryCreateRequest information about the category to create
     * @return the created category
     */
    Category create(CategoryCreateRequest categoryCreateRequest);

    /**
     * Updates information about a category.
     *
     * @param categoryUpdateRequest information to update the category
     * @return the updated category
     */
    Category update(CategoryUpdateRequest categoryUpdateRequest);

    /**
     * Retrieves information about a category by its ID.
     *
     * @param id the ID of the category
     * @return the category with the specified ID
     */
    Category getCategoryById(Long id);

    /**
     * Retrieves a list of all categories.
     *
     * @return a list of all categories
     */
    List<Category> getAllCategories();

}