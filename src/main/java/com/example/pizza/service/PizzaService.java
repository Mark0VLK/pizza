package com.example.pizza.service;

import com.example.pizza.model.Pizza;
import com.example.pizza.request.pizza.PizzaCreateRequest;
import com.example.pizza.request.pizza.PizzaUpdateRequest;

import java.util.List;


public interface PizzaService {

    Pizza create(PizzaCreateRequest pizzaCreateRequest);

    Pizza update(PizzaUpdateRequest pizzaUpdateRequest);

    Pizza getPizzaById(Long id);

    List<Pizza> getAllPizzas();

}
