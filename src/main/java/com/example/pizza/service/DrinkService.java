package com.example.pizza.service;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.response.DrinkResponse;

import java.util.List;


public interface DrinkService {

    /**
     * Deletes a drink by its ID.
     *
     * @param id      the ID of the drink to delete
     * @param deleteMode the mode indicating whether to delete the drink permanently or softly
     * @return the deleted DrinkResponse object containing drink if successfully deleted
     */
    DrinkResponse deleteById(Long id, DeleteMode deleteMode);

    /**
     * Creates a new drink based on the provided data.
     *
     * @param drinkCreateRequest the DrinkCreateRequest object containing information about drink to create
     * @return the created DrinkResponse object
     */
    DrinkResponse create(DrinkCreateRequest drinkCreateRequest);

    /**
     * Updates information about a drink.
     * @param id the ID of the drink to update
     * @param drinkCreateRequest the DrinkCreateRequest object containing information about drink to update
     * @return the updated DrinkResponse
     */
    DrinkResponse update(Long id, DrinkCreateRequest drinkCreateRequest);

    /**
     * Finds a drink by its ID.
     *
     * @param id the ID of the drink to find
     * @return the DrinkResponse object containing information about drink with the given ID
     */
    DrinkResponse getDrinkById(Long id);

    /**
     * Retrieves a list of all drinks.
     *
     * @return a list of all DrinkResponse object
     */
    List<DrinkResponse> getAllDrinks();

}