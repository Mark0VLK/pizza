package com.example.pizza.service;

import com.example.pizza.model.PizzaOrder;

import java.util.List;


public interface PizzaOrderService {

    PizzaOrder getPizzaOrderById(Long id);

    List<PizzaOrder> getAllPizzaOrders();

}