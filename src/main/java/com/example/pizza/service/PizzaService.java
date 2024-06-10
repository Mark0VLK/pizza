package com.example.pizza.service;

import com.example.pizza.model.Pizza;
import com.example.pizza.request.pizza.PizzaCreateRequest;
import com.example.pizza.request.pizza.PizzaUpdateRequest;

import java.util.List;


public interface PizzaService {

    /**
     * Creates a new pizza based on the provided data.
     *
     * @param pizzaCreateRequest the data for creating the pizza
     * @return the created pizza
     */
    Pizza create(PizzaCreateRequest pizzaCreateRequest);

    /**
     * Updates an existing pizza based on the provided data.
     *
     * @param pizzaUpdateRequest the data for updating the pizza
     * @return the updated pizza
     */
    Pizza update(PizzaUpdateRequest pizzaUpdateRequest);

    /**
     * Finds a pizza by the given ID.
     *
     * @param id the ID of the pizza
     * @return the pizza with the given ID, or null if not found
     */
    Pizza getPizzaById(Long id);

    /**
     * Returns a list of all pizzas.
     *
     * @return a list of all pizzas
     */
    List<Pizza> getAllPizzas();

}
