package com.example.pizza.mapper;

import com.example.pizza.model.Pizza;
import com.example.pizza.request.pizza.PizzaCreateRequest;
import com.example.pizza.response.PizzaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {InformationMapper.class})
public interface PizzaMapper {

    @Mapping(source = "informationId", target = "information")
    Pizza createRequestToPizza(PizzaCreateRequest pizzaCreateRequest);

    @Mapping(source = "information.id", target = "informationId")
    PizzaResponse pizzaToResponse(Pizza pizza);

    List<PizzaResponse> pizzasToResponses(List<Pizza> pizzas);
}