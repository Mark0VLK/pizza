package com.example.pizza.mapper;

import com.example.pizza.model.Dish;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.response.DishResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {
    Dish createRequestToDish(DishCreateRequest dishCreateRequest);
    DishResponse dishToResponse(Dish dish);
    List<DishResponse> dishesToResponses(List<Dish> dishes);
}
