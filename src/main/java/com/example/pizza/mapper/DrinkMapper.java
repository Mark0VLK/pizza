package com.example.pizza.mapper;

import com.example.pizza.model.Drink;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.response.DrinkResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {InformationMapper.class})
public interface DrinkMapper {
    @Mapping(source = "informationId", target = "information")
    Drink createRequestToDrink(DrinkCreateRequest drinkCreateRequest);
    @Mapping(source = "information.id", target = "informationId")
    DrinkResponse drinkToResponse(Drink drink);
    List<DrinkResponse> drinksToResponses(List<Drink> drinks);

}
