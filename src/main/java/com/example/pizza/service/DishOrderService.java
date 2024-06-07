package com.example.pizza.service;

import com.example.pizza.model.DishOrder;

import java.util.List;


public interface DishOrderService {

    DishOrder getDishesOrderById(Long id);
    List<DishOrder> getAllDishesOrders();

}
