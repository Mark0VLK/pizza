package com.example.pizza.service;

import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.response.OrderResponse;

import java.util.List;


public interface OrderService {

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete
     * @return the deleted OrderResponse object if successfully deleted
     */
    OrderResponse deleteById(Long id);

    /**
     * Creates a new order based on the provided request data.
     *
     * @param orderCreateRequest the OrderCreateRequest object containing the data for the new order
     * @return the created OrderResponse object
     */
    OrderResponse create(OrderCreateRequest orderCreateRequest);

    /**
     * Updates an existing order with the data provided in the request.
     * @param id the ID of the order to update
     * @param orderCreateRequest the OrderCreateRequest object containing the data for the order to update
     * @return the updated OrderResponse object
     */
    OrderResponse update(Long id, OrderCreateRequest orderCreateRequest);

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order to retrieve
     * @return the OrderResponse with the specified ID
     */
    OrderResponse getOrderById(Long id);

    /**
     * Retrieves all orders.
     *
     * @return a list of all OrderResponse objects
     */
    List<OrderResponse> getAllOrders();

}
