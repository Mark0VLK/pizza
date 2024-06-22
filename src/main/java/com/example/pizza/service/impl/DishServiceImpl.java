package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.DishMapper;
import com.example.pizza.mapper.DishOrderMapper;
import com.example.pizza.model.Dish;
import com.example.pizza.model.DishOrder;
import com.example.pizza.model.Information;
import com.example.pizza.model.Order;
import com.example.pizza.repositories.DishOrderRepository;
import com.example.pizza.repositories.DishRepository;
import com.example.pizza.repositories.InformationRepository;
import com.example.pizza.repositories.OrderRepository;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.request.dish.DishUpdateRequest;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.DishOrderResponse;
import com.example.pizza.response.DishResponse;
import com.example.pizza.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    private final InformationRepository informationRepository;
    private final DishOrderRepository dishOrderRepository;
    private final DishOrderMapper dishOrderMapper;
    private final OrderRepository orderRepository;

    @Override
    public DishResponse deleteById(Long id, DeleteMode deleteMode) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("dish", id));
        switch (deleteMode) {
            case HARD -> dishRepository.deleteById(id);
            case SOFT -> {
                dish.setIsDeleted(true);
                dishRepository.save(dish);
            }
        }
        return dishMapper.dishToResponse(dish);
    }

    @Override
    public DishResponse create(DishCreateRequest dishCreateRequest) {
        Dish dish = dishMapper.createRequestToDish(dishCreateRequest);
        dishRepository.save(dish);
        return dishMapper.dishToResponse(dish);
    }

    @Override
    public DishResponse update(Long id, DishUpdateRequest dishUpdateRequest) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("dish", id));
        Information information = informationRepository.findById(dishUpdateRequest.informationId())
                .orElseThrow(() -> new EntityNotFoundException("information", dishUpdateRequest.informationId()));
        updateDishFields(dish, dishUpdateRequest, information);
        dishRepository.save(dish);
        return dishMapper.dishToResponse(dish);
    }

    private void updateDishFields(Dish dish, DishUpdateRequest dishUpdateRequest, Information information) {
        dish.setNumberOfPieces(dishUpdateRequest.numberOfPieces());
        dish.setWeight(dishUpdateRequest.weight());
        dish.setPrice(dishUpdateRequest.price());
        dish.setInformation(information);
    }

    @Override
    public DishResponse getDishById(Long id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("dish", id));
        return dishMapper.dishToResponse(dish);
    }

    @Override
    public List<DishResponse> getAllDishes() {
        List<Dish> dishes = dishRepository.findAll();
        return dishMapper.dishesToResponses(dishes);
    }

    @Override
    public DishOrderResponse addDish(ProductOrderCreateRequest productOrderCreateRequest) {

        Long dishId = productOrderCreateRequest.productId();
        Long orderId = productOrderCreateRequest.orderId();

        DishOrder dishOrder = dishOrderMapper.createRequestToDishOrder(productOrderCreateRequest);
        dishOrder = dishOrderRepository.save(dishOrder);

        setDishAndOrderForDishOrder(dishId, orderId, dishOrder);

        return dishOrderMapper.dishOrderToResponse(dishOrder);
    }

    @Override
    @Transactional
    public DishOrderResponse changeDish(Long id, ProductOrderUpdateRequest productOrderUpdateRequest) {

        Long dishId = productOrderUpdateRequest.productId();
        Long orderId = productOrderUpdateRequest.orderId();

        DishOrder existingDishOrder = dishOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("dish from the order", id));

        dishOrderMapper.updateDishOrderFromRequest(productOrderUpdateRequest, existingDishOrder);

        setDishAndOrderForDishOrder(dishId, orderId, existingDishOrder);

        existingDishOrder = dishOrderRepository.save(existingDishOrder);

        return dishOrderMapper.dishOrderToResponse(existingDishOrder);
    }

    private void setDishAndOrderForDishOrder(Long dishId, Long orderId, DishOrder dishOrder) {

        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new EntityNotFoundException("dish", dishId));
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("order", orderId));

        dishOrder.setOrder(order);
        dishOrder.setDish(dish);
    }

    @Override
    public DishOrderResponse deleteDish(Long id) {

        DishOrder existingDishOrder = dishOrderRepository.findById(id)
                .map(pizzaOrder -> {
                    dishOrderRepository.deleteById(id);
                    return pizzaOrder;
                }).orElseThrow(() -> new EntityNotFoundException("pizza from the order", id));

        return dishOrderMapper.dishOrderToResponse(existingDishOrder);
    }
}
