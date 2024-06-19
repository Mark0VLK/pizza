package com.example.pizza.mapper.impl;

import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.PizzaOrderMapper;
import com.example.pizza.model.Order;
import com.example.pizza.model.Pizza;
import com.example.pizza.model.PizzaOrder;
import com.example.pizza.repositories.OrderRepository;
import com.example.pizza.repositories.PizzaOrderRepository;
import com.example.pizza.repositories.PizzaRepository;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PizzaOrderMapperImpl implements PizzaOrderMapper {

    private final PizzaOrderRepository pizzaOrderRepository;
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;

    @Override
    public PizzaOrder createRequestToPizzaOrder(ProductOrderCreateRequest createRequest) {
        PizzaOrder pizzaOrder = new PizzaOrder();
        populatePizzaOrder(
                pizzaOrder,
                createRequest.productId(),
                createRequest.orderId(),
                createRequest.quantity()
        );
        return pizzaOrder;
    }

    @Override
    public PizzaOrder updateRequestToPizzaOrder(Long id, ProductOrderUpdateRequest updateRequest) {
        PizzaOrder pizzaOrder = pizzaOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("pizza from the order", id));
        populatePizzaOrder(
                pizzaOrder,
                updateRequest.productId(),
                updateRequest.orderId(),
                updateRequest.quantity()
        );
        return pizzaOrder;
    }

    private void populatePizzaOrder(
            PizzaOrder pizzaOrder,
            Long pizzaId,
            Long orderId,
            int quantity) {

        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new EntityNotFoundException("pizza", pizzaId));
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("order", orderId));

        pizzaOrder.setPizza(pizza);
        pizzaOrder.setOrder(order);
        pizzaOrder.setQuantity(quantity);
    }
}
