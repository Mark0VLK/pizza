package com.example.pizza.service;

import com.example.pizza.model.Order;
import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.request.order.OrderUpdateRequest;

import java.util.List;


public interface OrderService {

    Order create(OrderCreateRequest orderCreateRequest);

    Order update(OrderUpdateRequest orderUpdateRequest);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

}
