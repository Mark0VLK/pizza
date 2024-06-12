package com.example.pizza.mapper;

import com.example.pizza.model.Drink;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.response.DrinkResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DrinkMapper {
    Drink createRequestToDrink(DrinkCreateRequest drinkCreateRequest);
    DrinkResponse drinkToResponse(Drink drink);
    List<DrinkResponse> drinksToResponses(List<Drink> drinks);

}
