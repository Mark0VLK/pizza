package com.example.pizza.controller;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.drink.DrinkCreateRequest;
import com.example.pizza.request.drink.DrinkUpdateRequest;
import com.example.pizza.response.DrinkResponse;
import com.example.pizza.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<DrinkResponse> create (@RequestBody DrinkCreateRequest drinkCreateRequest) {
        DrinkResponse drinkResponse = drinkService.create(drinkCreateRequest);
        return new ResponseEntity<>(drinkResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DrinkResponse> update (@PathVariable("id") Long id,
                                                 @RequestBody DrinkUpdateRequest drinkUpdateRequest) {
        DrinkResponse drinkResponse = drinkService.update(id, drinkUpdateRequest);
        return new ResponseEntity<>(drinkResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DrinkResponse> deleteDrink (@PathVariable("id") Long id,
                                                 @RequestParam(value = "deleteMode",
                                                         defaultValue = "SOFT") DeleteMode deleteMode) {
        DrinkResponse drinkResponse = drinkService.deleteById(id, deleteMode);
        return new ResponseEntity<>(drinkResponse, HttpStatus.OK);
    }
}
