package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.DrinkMapper;
import com.example.pizza.model.Drink;
import com.example.pizza.model.Information;
import com.example.pizza.repositories.DrinkRepository;
import com.example.pizza.repositories.InformationRepository;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.request.drink.DrinkUpdateRequest;
import com.example.pizza.response.DrinkResponse;
import com.example.pizza.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;
    private final DrinkMapper drinkMapper;
    private final InformationRepository informationRepository;

    @Override
    public DrinkResponse deleteById(Long id, DeleteMode deleteMode) {
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("drink", id));
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
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("drink", id));
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
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("drink", id));
        return drinkMapper.drinkToResponse(drink);
    }

    @Override
    public List<DrinkResponse> getAllDrinks() {
        List<Drink> drinks = drinkRepository.findAll();
        return drinkMapper.drinksToResponses(drinks);
    }
}
