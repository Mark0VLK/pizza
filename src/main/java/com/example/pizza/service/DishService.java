package com.example.pizza.service;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.response.DishResponse;

import java.util.List;


public interface DishService {

    /**
     * Deletes a dish by its ID.
     *
     * @param id      the ID of the dish to delete
     * @param deleteMode the mode indicating whether to delete the dish permanently or softly
     * @return the deleted DishResponse object containing dish information if successfully deleted
     */
    DishResponse deleteById(Long id, DeleteMode deleteMode);

    /**
     * Creates a new dish.
     *
     * @param dishCreateRequest the DishCreateRequest object containing information about the dish to create
     * @return the created DishResponse object
     */
    DishResponse create(DishCreateRequest dishCreateRequest);

    /**
     * Updates information about a dish.
     * @param id the ID of the dish to update
     * @param dishCreateRequest the DishCreateRequest object containing information to update the dish
     * @return the updated DishResponse object containing information about dish
     */
    DishResponse update(Long id, DishCreateRequest dishCreateRequest);

    /**
     * Retrieves information about a dish by its ID.
     *
     * @param id the ID of the dish
     * @return the DishResponse containing information about the dish with the specified ID
     */
    DishResponse getDishById(Long id);

    /**
     * Retrieves a list of all dishes.
     *
     * @return a list of all DishRequest objects
     */
    List<DishResponse> getAllDishes();

}