package com.example.pizza.service.impl;

import com.example.pizza.model.Pizza;
import com.example.pizza.request.pizza.PizzaCreateRequest;
import com.example.pizza.request.pizza.PizzaUpdateRequest;
import com.example.pizza.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Override
    public Pizza deleteById(Long id, boolean forever) {

        return null;
    }

    @Override
    public Pizza create(PizzaCreateRequest pizzaCreateRequest) {

        return null;
    }

    @Override
    public Pizza update(PizzaUpdateRequest pizzaUpdateRequest) {

        return null;
    }

    @Override
    public Pizza getPizzaById(Long id) {

        return null;
    }

    @Override
    public List<Pizza> getAllPizzas() {

        return null;
    }
}
