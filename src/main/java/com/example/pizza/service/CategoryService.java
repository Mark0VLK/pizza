package com.example.pizza.service;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.CategoryCreateRequest;
import com.example.pizza.response.CategoryResponse;

import java.util.List;


public interface CategoryService {

    /**
     * Deletes a category by its ID.
     *
     * @param id         the ID of the category to delete
     * @param deleteMode the mode indicating whether to delete the category permanently or softly
     * @return the deleted CategoryResponse if successfully deleted
     */
    CategoryResponse deleteById(Long id, DeleteMode deleteMode);

    /**
     * Creates a new category.
     *
     * @param categoryCreateRequest the CategoryCreateRequest object containing category information
     * @return the created CategoryResponse object
     */
    CategoryResponse create(CategoryCreateRequest categoryCreateRequest);

    /**
     * Updates information about a category.
     *
     * @param id                    the ID of the category to update
     * @param categoryCreateRequest the CategoryCreateRequest object containing category information
     * @return the updated CategoryResponse object
     */
    CategoryResponse update(Long id, CategoryCreateRequest categoryCreateRequest);

    /**
     * Retrieves information about a category by its ID.
     *
     * @param id the ID of the category
     * @return the CategoryResponse object containing category information with the specified ID
     */
    CategoryResponse getCategoryById(Long id);

    /**
     * Retrieves a list of all categories.
     *
     * @return a list of all CategoryResponse objects
     */
    List<CategoryResponse> getAllCategories();

}