package com.example.pizza.controller;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.pizza.PizzaCreateRequest;
import com.example.pizza.request.pizza.PizzaUpdateRequest;
import com.example.pizza.request.product.ProductOrderCreateRequest;
import com.example.pizza.request.product.ProductOrderUpdateRequest;
import com.example.pizza.response.PizzaOrderResponse;
import com.example.pizza.response.PizzaResponse;
import com.example.pizza.service.PizzaService;
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
@RequestMapping("/api/v1/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<PizzaResponse>> getAllPizza() {
        List<PizzaResponse> pizzaResponses = pizzaService.getAllPizzas();
        return new ResponseEntity<>(pizzaResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaResponse> getPizzaById(@PathVariable Long id) {
        PizzaResponse pizzaResponse = pizzaService.getPizzaById(id);
        return new ResponseEntity<>(pizzaResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PizzaResponse> create(@RequestBody PizzaCreateRequest pizzaCreateRequest) {
        PizzaResponse pizzaResponse = pizzaService.create(pizzaCreateRequest);
        return new ResponseEntity<>(pizzaResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaResponse> update(@PathVariable Long id,
                                                @RequestBody PizzaUpdateRequest pizzaUpdateRequest) {
        PizzaResponse pizzaResponse = pizzaService.update(id, pizzaUpdateRequest);
        return new ResponseEntity<>(pizzaResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PizzaResponse> delete(@PathVariable("id") Long id,
                                                @RequestParam(value = "deleteMode", defaultValue = "SOFT")
                                                DeleteMode deleteMode) {
        PizzaResponse pizzaResponse = pizzaService.deleteById(id, deleteMode);
        return new ResponseEntity<>(pizzaResponse, HttpStatus.OK);
    }

    @PostMapping("/product-order")
    public ResponseEntity<PizzaOrderResponse> addPizzaToTheOrder(
            @RequestBody ProductOrderCreateRequest productOrderCreateRequest) {
        PizzaOrderResponse pizzaOrderResponse = pizzaService.addPizza(productOrderCreateRequest);
        return new ResponseEntity<>(pizzaOrderResponse, HttpStatus.CREATED);
    }

    @PutMapping("/product-order/{id}")
    public ResponseEntity<PizzaOrderResponse> changePizzaInTheOrder(
            @RequestBody ProductOrderUpdateRequest productOrderUpdateRequest,
            @PathVariable Long id) {
        PizzaOrderResponse pizzaOrderResponse = pizzaService.changePizza(id, productOrderUpdateRequest);
        return new ResponseEntity<>(pizzaOrderResponse, HttpStatus.OK);
    }

    @DeleteMapping("/product-order/{id}")
    public ResponseEntity<PizzaOrderResponse> removePizzaFromTheOrder(@PathVariable Long id) {
        PizzaOrderResponse pizzaOrderResponse = pizzaService.deletePizza(id);
        return new ResponseEntity<>(pizzaOrderResponse, HttpStatus.OK);
    }
}
