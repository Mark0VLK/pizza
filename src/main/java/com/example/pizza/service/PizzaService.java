package com.example.pizza.service;

import com.example.pizza.model.Pizza;

import java.util.List;


public interface PizzaService {

    Pizza getPizzaById(Long id);

    List<Pizza> getAllPizzas();

}
