package com.example.pizza.service;

import com.example.pizza.model.Dish;

import java.util.List;


public interface DishService {

    Dish getDishesById(Long id);
    List<Dish> getAllDishes();

}