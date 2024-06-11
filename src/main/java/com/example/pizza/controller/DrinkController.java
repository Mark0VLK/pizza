package com.example.pizza.controller;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.request.drink.DrinkUpdateRequest;
import com.example.pizza.response.DrinkResponse;
import com.example.pizza.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drink")
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping
    public ResponseEntity<List<DrinkResponse>> getDrinks() {
        List<DrinkResponse> drinkResponse = drinkService.getAllDrinks();
        return new ResponseEntity<>(drinkResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrinkResponse> getDrinkById(@PathVariable("id") Long id) {
        DrinkResponse drinkResponse = drinkService.getDrinkById(id);
        return new ResponseEntity<>(drinkResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DrinkResponse> create(@RequestBody DrinkCreateRequest drinkCreateRequest) {
        DrinkResponse drinkResponse = drinkService.create(drinkCreateRequest);
        return new ResponseEntity<>(drinkResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DrinkResponse> update(@PathVariable("id") Long id,
                                                @RequestBody DrinkUpdateRequest drinkUpdateRequest) {
        DrinkResponse drinkResponse = drinkService.update(id, drinkUpdateRequest);
        return new ResponseEntity<>(drinkResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DrinkResponse> delete(@PathVariable("id") Long id,
                                                     @RequestParam(value = "deleteMode",
                                                             defaultValue = "SOFT") DeleteMode deleteMode) {
        DrinkResponse drinkResponse = drinkService.deleteById(id, deleteMode);
        return new ResponseEntity<>(drinkResponse, HttpStatus.OK);
    }
}
