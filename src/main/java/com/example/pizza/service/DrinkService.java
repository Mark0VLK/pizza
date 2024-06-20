package com.example.pizza.service;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.request.drink.DrinkUpdateRequest;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.DrinkOrderResponse;
import com.example.pizza.response.DrinkResponse;

import java.util.List;


public interface DrinkService {

    /**
     * Deletes a drink by its ID.
     *
     * @param id         the ID of the drink to delete
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
     *
     * @param id                 the ID of the drink to update
     * @param drinkUpdateRequest the request object containing updated drink information
     * @return the updated DrinkResponse
     */
    DrinkResponse update(Long id, DrinkUpdateRequest drinkUpdateRequest);

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

    /**
     * Adds a new drink order based on the provided request.
     *
     * @param productOrderCreateRequest the request containing data for creating a new drink order
     * @return the newly created drink order
     */
    DrinkOrderResponse addDrink(ProductOrderCreateRequest productOrderCreateRequest);

    /**
     * Changes an existing drink order based on the provided update request.
     *
     * @param id                        the ID of the drink order to change
     * @param productOrderUpdateRequest the request containing data for updating an existing drink order
     * @return the updated drink order
     */
    DrinkOrderResponse changeDrink(Long id, ProductOrderUpdateRequest productOrderUpdateRequest);

    /**
     * Deletes a drink order with the specified ID.
     *
     * @param id the ID of the drink order to delete
     * @return the deleted drink order
     */
    DrinkOrderResponse deleteDrink(Long id);
}