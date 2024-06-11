package com.example.pizza.controller;

import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.request.order.OrderUpdateRequest;
import com.example.pizza.response.OrderResponse;
import com.example.pizza.service.OrderService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> orderResponses = orderService.getAllOrders();
        return new ResponseEntity<>(orderResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") Long id) {
        OrderResponse orderResponse = orderService.getOrderById(id);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OrderResponse> create(@RequestBody OrderCreateRequest orderCreateRequest) {
        OrderResponse orderResponse = orderService.create(orderCreateRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> update(@PathVariable("id") Long id,
                                                @RequestBody OrderUpdateRequest orderUpdateRequest) {
        OrderResponse orderResponse = orderService.update(id, orderUpdateRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponse> delete(@PathVariable("id") Long id) {
        OrderResponse orderResponse = orderService.deleteById(id);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
