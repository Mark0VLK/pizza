package com.example.pizza.service.impl;

import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.request.order.OrderUpdateRequest;
import com.example.pizza.response.OrderResponse;
import com.example.pizza.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderResponse deleteById(Long id) {

        return null;
    }

    @Override
    public OrderResponse create(OrderCreateRequest orderCreateRequest) {

        return null;
    }

    @Override
    public OrderResponse update(Long id, OrderUpdateRequest orderUpdateRequest) {

        return null;
    }

    @Override
    public OrderResponse getOrderById(Long id) {

        return null;
    }

    @Override
    public List<OrderResponse> getAllOrders() {

        return null;
    }
}
