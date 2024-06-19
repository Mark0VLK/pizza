package com.example.pizza.mapper.impl;

import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.DrinkOrderMapper;
import com.example.pizza.model.Drink;
import com.example.pizza.model.DrinkOrder;
import com.example.pizza.model.Order;
import com.example.pizza.repositories.DrinkOrderRepository;
import com.example.pizza.repositories.DrinkRepository;
import com.example.pizza.repositories.OrderRepository;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DrinkOrderMapperImpl implements DrinkOrderMapper {
    private final DrinkOrderRepository drinkOrderRepository;
    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;

    @Override
    public DrinkOrder createRequestToDrinkOrder(ProductOrderCreateRequest createRequest) {
        DrinkOrder drinkOrder = new DrinkOrder();
        populateDrinkOrder(
                drinkOrder,
                createRequest.productId(),
                createRequest.orderId(),
                createRequest.quantity()
        );
        return drinkOrder;
    }

    @Override
    public DrinkOrder updateRequestToDrinkOrder(Long id, ProductOrderUpdateRequest updateRequest) {
        DrinkOrder drinkOrder = drinkOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("drink from the order", id));
        populateDrinkOrder(
                drinkOrder,
                updateRequest.productId(),
                updateRequest.orderId(),
                updateRequest.quantity()
        );
        return drinkOrder;
    }

    private void populateDrinkOrder(
            DrinkOrder drinkOrder,
            Long drinkId,
            Long orderId,
            int quantity) {

        Drink drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new EntityNotFoundException("drink", drinkId));
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("order", orderId));

        drinkOrder.setDrink(drink);
        drinkOrder.setOrder(order);
        drinkOrder.setQuantity(quantity);
    }
}
