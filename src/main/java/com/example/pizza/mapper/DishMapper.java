package com.example.pizza.mapper;

import com.example.pizza.model.Dish;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.response.DishResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {InformationMapper.class})
public interface DishMapper {

    @Mapping(source = "informationId", target = "information")
    Dish createRequestToDish(DishCreateRequest dishCreateRequest);

    @Mapping(source = "information.id", target = "informationId")
    DishResponse dishToResponse(Dish dish);

    List<DishResponse> dishesToResponses(List<Dish> dishes);

    @Mapping(target = "id", source = "productId")
    Dish toEntity(Long productId);
}
