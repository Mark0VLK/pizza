package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.DrinkMapper;
import com.example.pizza.mapper.DrinkOrderMapper;
import com.example.pizza.model.Drink;
import com.example.pizza.model.DrinkOrder;
import com.example.pizza.model.Information;
import com.example.pizza.model.Order;
import com.example.pizza.repositories.DrinkOrderRepository;
import com.example.pizza.repositories.DrinkRepository;
import com.example.pizza.repositories.InformationRepository;
import com.example.pizza.repositories.OrderRepository;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.request.drink.DrinkUpdateRequest;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.DrinkOrderResponse;
import com.example.pizza.response.DrinkResponse;
import com.example.pizza.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;
    private final DrinkMapper drinkMapper;
    private final InformationRepository informationRepository;
    private final DrinkOrderRepository drinkOrderRepository;
    private final DrinkOrderMapper drinkOrderMapper;
    private final OrderRepository orderRepository;

    @Override
    public DrinkResponse deleteById(Long id, DeleteMode deleteMode) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("drink", id));
        switch (deleteMode) {
            case HARD -> drinkRepository.deleteById(id);
            case SOFT -> {
                drink.setIsDeleted(true);
                drinkRepository.save(drink);
            }
        }
        return drinkMapper.drinkToResponse(drink);
    }

    @Override
    public DrinkResponse create(DrinkCreateRequest drinkCreateRequest) {
        Drink drink = drinkMapper.createRequestToDrink(drinkCreateRequest);
        drinkRepository.save(drink);
        return drinkMapper.drinkToResponse(drink);
    }

    @Override
    public DrinkResponse update(Long id, DrinkUpdateRequest drinkUpdateRequest) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("drink", id));
        drink.setVolume(drinkUpdateRequest.volume());
        drink.setPrice(drinkUpdateRequest.price());
        Information information = informationRepository.findById(drinkUpdateRequest.informationId())
                .orElseThrow(() -> new EntityNotFoundException("information", drinkUpdateRequest.informationId()));
        drink.setInformation(information);
        drinkRepository.save(drink);
        return drinkMapper.drinkToResponse(drink);
    }

    @Override
    public DrinkResponse getDrinkById(Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("drink", id));
        return drinkMapper.drinkToResponse(drink);
    }

    @Override
    public List<DrinkResponse> getAllDrinks() {
        List<Drink> drinks = drinkRepository.findAll();
        return drinkMapper.drinksToResponses(drinks);
    }

    @Override
    public DrinkOrderResponse addDrink(ProductOrderCreateRequest productOrderCreateRequest) {

        Long drinkId = productOrderCreateRequest.productId();
        Long orderId = productOrderCreateRequest.orderId();

        DrinkOrder drinkOrder = drinkOrderMapper.createRequestToDrinkOrder(productOrderCreateRequest);
        drinkOrder = drinkOrderRepository.save(drinkOrder);

        setDrinkAndOrderForDrinkOrder(drinkId, orderId, drinkOrder);

        return drinkOrderMapper.drinkOrderToResponse(drinkOrder);
    }

    @Override
    @Transactional
    public DrinkOrderResponse changeDrink(Long id, ProductOrderUpdateRequest productOrderUpdateRequest) {

        Long drinkId = productOrderUpdateRequest.productId();
        Long orderId = productOrderUpdateRequest.orderId();

        DrinkOrder existingDrinkOrder = drinkOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("drink from the order", id));

        drinkOrderMapper.updateDrinkOrderFromRequest(productOrderUpdateRequest, existingDrinkOrder);

        setDrinkAndOrderForDrinkOrder(drinkId, orderId, existingDrinkOrder);

        existingDrinkOrder = drinkOrderRepository.save(existingDrinkOrder);

        return drinkOrderMapper.drinkOrderToResponse(existingDrinkOrder);
    }

    private void setDrinkAndOrderForDrinkOrder(Long drinkId, Long orderId, DrinkOrder drinkOrder) {

        Drink drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new EntityNotFoundException("drink", drinkId));
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("order", orderId));

        drinkOrder.setOrder(order);
        drinkOrder.setDrink(drink);
    }

    @Override
    public DrinkOrderResponse deleteDrink(Long id) {

        DrinkOrder existingDrinkOrder = drinkOrderRepository.findById(id)
                .map(pizzaOrder -> {
                    drinkOrderRepository.deleteById(id);
                    return pizzaOrder;
                }).orElseThrow(() -> new EntityNotFoundException("pizza from the order", id));

        return drinkOrderMapper.drinkOrderToResponse(existingDrinkOrder);
    }
}
