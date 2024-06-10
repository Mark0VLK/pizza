package com.example.pizza.service.impl;

import com.example.pizza.model.Dish;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.request.dish.DishUpdateRequest;
import com.example.pizza.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Override
    public Dish deleteById(Long id, boolean forever) {

        return null;
    }

    @Override
    public Dish create(DishCreateRequest dishCreateRequest) {

        return null;
    }

    @Override
    public Dish update(DishUpdateRequest dishUpdateRequest) {

        return null;
    }

    @Override
    public Dish getDishById(Long id) {

        return null;
    }

    @Override
    public List<Dish> getAllDishes() {

        return null;
    }
}
