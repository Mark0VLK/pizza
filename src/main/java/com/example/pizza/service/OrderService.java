package com.example.pizza.service;

import com.example.pizza.model.Order;

import java.util.List;


public interface OrderService {

    Order getOrderById(Long id);

    List<Order> getAllOrders();

}
