package com.example.pizza.service;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.PizzaCreateRequest;
import com.example.pizza.response.PizzaResponse;

import java.util.List;


public interface PizzaService {

    /**
     * This method allows for both permanent and soft deletion of pizza based on the forever flag.
     *
     * @param id         the ID of the pizza to delete
     * @param deleteMode the mode indicating whether to delete the pizza permanently or softly
     * @return the deleted PizzaResponse if successfully deleted
     */
    PizzaResponse deleteById(Long id, DeleteMode deleteMode);

    /**
     * Creates a new pizza based on the provided data.
     *
     * @param pizzaCreateRequest the PizzaCreateRequest object containing data for creating the pizza
     * @return the created PizzaResponse object
     */
    PizzaResponse create(PizzaCreateRequest pizzaCreateRequest);

    /**
     * Updates an existing pizza based on the provided data.
     *
     * @param id                 the ID of the pizza to update
     * @param pizzaCreateRequest the PizzaCreateRequest object containing data for updating the pizza
     * @return the updated PizzaResponse object
     */
    PizzaResponse update(Long id, PizzaCreateRequest pizzaCreateRequest);

    /**
     * Finds a pizza by the given ID.
     *
     * @param id the ID of the pizza
     * @return the PizzaResponse object with the given ID
     */
    PizzaResponse getPizzaById(Long id);

    /**
     * Returns a list of all pizzas.
     *
     * @return a list of all PizzaResponse objects
     */
    List<PizzaResponse> getAllPizzas();

}
