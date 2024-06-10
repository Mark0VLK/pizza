package com.example.pizza.service;

import com.example.pizza.model.Drink;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.request.drink.DrinkUpdateRequest;

import java.util.List;


public interface DrinkService {

    /**
     * Creates a new drink based on the provided data.
     *
     * @param drinkCreateRequest the data for creating the drink
     * @return the newly created drink
     */
    Drink create(DrinkCreateRequest drinkCreateRequest);

    /**
     * Updates an existing drink with the provided data.
     *
     * @param drinkUpdateRequest the data for updating the drink
     * @return the updated drink
     */
    Drink update(DrinkUpdateRequest drinkUpdateRequest);

    /**
     * Finds a drink by its ID.
     *
     * @param id the ID of the drink to find
     * @return the drink with the given ID, or null if not found
     */
    Drink getDrinkById(Long id);

    /**
     * Retrieves a list of all drinks.
     *
     * @return a list of all drinks
     */
    List<Drink> getAllDrinks();

}