package com.example.pizza.service.impl;

import com.example.pizza.model.Order;
import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.request.order.OrderUpdateRequest;
import com.example.pizza.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order deleteById(Long id) {

        return null;
    }

    @Override
    public Order create(OrderCreateRequest orderCreateRequest) {

        return null;
    }

    @Override
    public Order update(OrderUpdateRequest orderUpdateRequest) {

        return null;
    }

    @Override
    public Order getOrderById(Long id) {

        return null;
    }

    @Override
    public List<Order> getAllOrders() {

        return null;
    }
}
