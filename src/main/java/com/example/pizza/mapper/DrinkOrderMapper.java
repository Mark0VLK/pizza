package com.example.pizza.mapper;

import com.example.pizza.model.DrinkOrder;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;

public interface DrinkOrderMapper {

    DrinkOrder createRequestToDrinkOrder(ProductOrderCreateRequest createRequest);

    DrinkOrder updateRequestToDrinkOrder(Long id, ProductOrderUpdateRequest updateRequest);
}
