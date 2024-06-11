package com.example.pizza.controller;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.model.Dish;
import com.example.pizza.request.dish.DishCreateRequest;
import com.example.pizza.request.dish.DishUpdateRequest;
import com.example.pizza.response.DishResponse;
import com.example.pizza.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dish")
public class DishController {
    private final DishService dishService;
    @GetMapping
    public ResponseEntity<List<DishResponse>> getAllDishes() {
        List<DishResponse> dishResponses = dishService.getAllDishes();
        return new ResponseEntity<>(dishResponses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DishResponse> getDishById(@PathVariable("id") Long id) {
        DishResponse dishResponse = dishService.getDishById(id);
        return new ResponseEntity<>(dishResponse, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<DishResponse> create(@RequestBody DishCreateRequest dishCreateRequest) {
        DishResponse dishResponse = dishService.create(dishCreateRequest);
        return new ResponseEntity<>(dishResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DishResponse> update(@PathVariable("id") Long id,
                                               @RequestBody DishUpdateRequest dishUpdateRequest) {
        DishResponse dishResponse = dishService.update(id, dishUpdateRequest);
        return new ResponseEntity<>(dishResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DishResponse> deleteDish(@PathVariable("id") Long id,
                                                   @RequestParam(value = "deleteMode",
                                                           defaultValue = "SOFT") DeleteMode deleteMode) {
        DishResponse dishResponse = dishService.deleteById(id, deleteMode);
        return new ResponseEntity<>(dishResponse, HttpStatus.OK);
    }
}
