package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.PizzaMapper;
import com.example.pizza.mapper.PizzaOrderMapper;
import com.example.pizza.model.Information;
import com.example.pizza.model.Pizza;
import com.example.pizza.model.PizzaOrder;
import com.example.pizza.repositories.InformationRepository;
import com.example.pizza.repositories.PizzaOrderRepository;
import com.example.pizza.repositories.PizzaRepository;
import com.example.pizza.request.pizza.PizzaCreateRequest;
import com.example.pizza.request.pizza.PizzaUpdateRequest;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.PizzaResponse;
import com.example.pizza.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;
    private final InformationRepository informationRepository;
    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaOrderMapper pizzaOrderMapper;

    @Override
    public PizzaResponse deleteById(Long id, DeleteMode deleteMode) {

        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("pizza", id));
        switch (deleteMode) {
            case HARD -> pizzaRepository.deleteById(id);
            case SOFT -> {
                pizza.setIsDeleted(true);
                pizzaRepository.save(pizza);
            }
        }
        return pizzaMapper.pizzaToResponse(pizza);
    }

    @Override
    public PizzaResponse create(PizzaCreateRequest pizzaCreateRequest) {

        Pizza pizza = pizzaMapper.createRequestToPizza(pizzaCreateRequest);
        pizzaRepository.save(pizza);
        return pizzaMapper.pizzaToResponse(pizza);
    }

    @Override
    public PizzaResponse update(Long id, PizzaUpdateRequest pizzaUpdateRequest) {

        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("pizza", id));
        updatePizzaFields(pizza, pizzaUpdateRequest);
        pizzaRepository.save(pizza);
        return pizzaMapper.pizzaToResponse(pizza);
    }

    private void updatePizzaFields(Pizza pizza, PizzaUpdateRequest pizzaUpdateRequest) {

        Information information = informationRepository.findById(pizzaUpdateRequest.informationId())
                .orElseThrow(() -> new EntityNotFoundException("information"
                        , pizzaUpdateRequest.informationId()));
        pizza.setDiameter(pizzaUpdateRequest.diameter());
        pizza.setWeight(pizzaUpdateRequest.weight());
        pizza.setPrice(pizzaUpdateRequest.price());
        pizza.setInformation(information);
    }

    @Override
    public PizzaResponse getPizzaById(Long id) {

        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("pizza", id));
        return pizzaMapper.pizzaToResponse(pizza);
    }

    @Override
    public List<PizzaResponse> getAllPizzas() {

        List<Pizza> pizzas = pizzaRepository.findAll();
        return pizzaMapper.pizzasToResponses(pizzas);
    }

    @Override
    public PizzaOrder addPizza(ProductOrderCreateRequest productOrderCreateRequest) {

        PizzaOrder pizzaOrder = pizzaOrderMapper.createRequestToPizzaOrder(productOrderCreateRequest);
        return pizzaOrderRepository.save(pizzaOrder);
    }

    @Override
    public PizzaOrder changePizza(Long id, ProductOrderUpdateRequest productOrderUpdateRequest) {

        PizzaOrder pizzaOrder = pizzaOrderMapper.updateRequestToPizzaOrder(id, productOrderUpdateRequest);
        return pizzaOrderRepository.save(pizzaOrder);
    }

    @Override
    public PizzaOrder deletePizza(Long id) {

        return pizzaOrderRepository.findById(id).map(pizzaOrder -> {
            pizzaOrderRepository.deleteById(id);
            return pizzaOrder;
        }).orElseThrow(() -> new EntityNotFoundException("pizza from the order", id));
    }
}
