package com.example.pizza.service;

import com.example.pizza.model.Category;

import java.util.List;


public interface CategoryService {

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

}