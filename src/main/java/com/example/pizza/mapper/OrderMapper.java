package com.example.pizza.mapper;

import com.example.pizza.model.Order;
import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {LocationMapper.class,UserMapper.class})
public interface OrderMapper {

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "locationId", target = "location")
    Order createRequestToOrder(OrderCreateRequest orderCreateRequest);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "location.id", target = "locationId")
    OrderResponse orderToResponse(Order order);

    List<OrderResponse> ordersToResponses(List<Order> orders);
}