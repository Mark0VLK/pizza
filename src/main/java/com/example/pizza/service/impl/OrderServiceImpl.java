package com.example.pizza.service.impl;

import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.OrderMapper;
import com.example.pizza.model.Location;
import com.example.pizza.model.Order;
import com.example.pizza.model.User;
import com.example.pizza.repositories.LocationRepository;
import com.example.pizza.repositories.OrderRepository;
import com.example.pizza.repositories.UserRepository;
import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.request.order.OrderUpdateRequest;
import com.example.pizza.response.OrderResponse;
import com.example.pizza.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Override
    public OrderResponse deleteById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order", id));
        orderRepository.deleteById(id);
        return orderMapper.orderToResponse(order);
    }

    @Override
    public OrderResponse create(OrderCreateRequest orderCreateRequest) {

        Order order = orderMapper.createRequestToOrder(orderCreateRequest);
        orderRepository.save(order);
        return orderMapper.orderToResponse(order);
    }

    @Override
    public OrderResponse update(Long id, OrderUpdateRequest orderUpdateRequest) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order", id));
        updateOrderFields(order, orderUpdateRequest);
        orderRepository.save(order);
        return orderMapper.orderToResponse(order);

    }

    private void updateOrderFields(Order order, OrderUpdateRequest orderUpdateRequest){

        User user = userRepository.findById(orderUpdateRequest.userId())
                .orElseThrow(() -> new EntityNotFoundException("user", orderUpdateRequest.userId()));
        Location location = locationRepository.findById(orderUpdateRequest.locationId())
                .orElseThrow(() -> new EntityNotFoundException("location", orderUpdateRequest.locationId()));
        order.setUser(user);
        order.setLocation(location);
    }

    @Override
    public OrderResponse getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order", id));
        return orderMapper.orderToResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {

        List<Order> orders = orderRepository.findAll();
        return orderMapper.ordersToResponses(orders);
    }
}
