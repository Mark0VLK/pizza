package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.response.DrinkResponse;
import com.example.pizza.service.DrinkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Override
    public DrinkResponse deleteById(Long id, DeleteMode deleteMode) {

        return null;
    }

    @Override
    public DrinkResponse create(DrinkCreateRequest drinkCreateRequest) {

        return null;
    }

    @Override
    public DrinkResponse update(Long id, DrinkCreateRequest drinkCreateRequest) {

        return null;
    }

    @Override
    public DrinkResponse getDrinkById(Long id) {

        return null;
    }

    @Override
    public List<DrinkResponse> getAllDrinks() {

        return null;
    }
}
