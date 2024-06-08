package com.example.pizza.service;

import com.example.pizza.model.Drink;

import java.util.List;


public interface DrinkService {

    Drink getDrinkById(Long id);

    List<Drink> getAllDrinks();

}