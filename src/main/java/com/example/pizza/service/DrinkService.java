package com.example.pizza.service;

import com.example.pizza.model.Drink;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.request.drink.DrinkUpdateRequest;

import java.util.List;


public interface DrinkService {

    Drink create(DrinkCreateRequest drinkCreateRequest);

    Drink update(DrinkUpdateRequest drinkUpdateRequest);

    Drink getDrinkById(Long id);

    List<Drink> getAllDrinks();

}