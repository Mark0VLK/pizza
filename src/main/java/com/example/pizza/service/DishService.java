package com.example.pizza.service;

import com.example.pizza.model.Dish;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.request.dish.DishUpdateRequest;

import java.util.List;


public interface DishService {

    /**
     * Creates a new dish.
     *
     * @param dishCreateRequest information about the dish to create
     * @return the created dish
     */
    Dish create(DishCreateRequest dishCreateRequest);

    /**
     * Updates information about a dish.
     *
     * @param dishUpdateRequest information to update the dish
     * @return the updated dish
     */
    Dish update(DishUpdateRequest dishUpdateRequest);

    /**
     * Retrieves information about a dish by its ID.
     *
     * @param id the ID of the dish
     * @return the dish with the specified ID
     */
    Dish getDishById(Long id);

    /**
     * Retrieves a list of all dishes.
     *
     * @return a list of all dishes
     */
    List<Dish> getAllDishes();

}