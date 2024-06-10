package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.PizzaCreateRequest;
import com.example.pizza.response.PizzaResponse;
import com.example.pizza.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Override
    public PizzaResponse deleteById(Long id, DeleteMode deleteMode) {

        return null;
    }

    @Override
    public PizzaResponse create(PizzaCreateRequest pizzaCreateRequest) {

        return null;
    }

    @Override
    public PizzaResponse update(Long id, PizzaCreateRequest pizzaCreateRequest) {

        return null;
    }

    @Override
    public PizzaResponse getPizzaById(Long id) {

        return null;
    }

    @Override
    public List<PizzaResponse> getAllPizzas() {

        return null;
    }
}
