package com.example.pizza.service;

import com.example.pizza.model.Dish;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.request.dish.DishUpdateRequest;

import java.util.List;


public interface DishService {

    Dish create(DishCreateRequest dishCreateRequest);

    Dish update(DishUpdateRequest dishUpdateRequest);

    Dish getDishesById(Long id);

    List<Dish> getAllDishes();

}