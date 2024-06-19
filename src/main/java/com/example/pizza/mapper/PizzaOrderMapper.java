package com.example.pizza.mapper;


import com.example.pizza.model.PizzaOrder;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;

public interface PizzaOrderMapper {

    PizzaOrder createRequestToPizzaOrder(ProductOrderCreateRequest createRequest);

    PizzaOrder updateRequestToPizzaOrder(Long id, ProductOrderUpdateRequest createRequest);
}
