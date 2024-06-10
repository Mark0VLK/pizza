package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.DishCreateRequest;
import com.example.pizza.response.DishResponse;
import com.example.pizza.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Override
    public DishResponse deleteById(Long id, DeleteMode deleteMode) {

        return null;
    }

    @Override
    public DishResponse create(DishCreateRequest dishCreateRequest) {

        return null;
    }

    @Override
    public DishResponse update(Long id, DishCreateRequest dishCreateRequest) {

        return null;
    }

    @Override
    public DishResponse getDishById(Long id) {

        return null;
    }

    @Override
    public List<DishResponse> getAllDishes() {

        return null;
    }
}
