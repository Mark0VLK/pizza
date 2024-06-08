package com.example.pizza.service;

import com.example.pizza.model.DrinkOrder;

import java.util.List;


public interface DrinkOrderService {

    DrinkOrder getDrinkOrderById(Long id);

    List<DrinkOrder> getAllDrinkOrders();

}