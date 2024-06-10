package com.example.pizza.service;

import com.example.pizza.model.Order;
import com.example.pizza.request.order.OrderCreateRequest;
import com.example.pizza.request.order.OrderUpdateRequest;

import java.util.List;


public interface OrderService {

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete
     * @return the deleted order
     */
    Order deleteById(Long id);

    /**
     * Creates a new order based on the provided request data.
     *
     * @param orderCreateRequest the request containing the data for the new order
     * @return the newly created order
     */
    Order create(OrderCreateRequest orderCreateRequest);

    /**
     * Updates an existing order with the data provided in the request.
     *
     * @param orderUpdateRequest the request containing the updated data for the order
     * @return the updated order
     */
    Order update(OrderUpdateRequest orderUpdateRequest);

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order to retrieve
     * @return the order with the specified ID
     */
    Order getOrderById(Long id);

    /**
     * Retrieves all orders.
     *
     * @return a list of all orders
     */
    List<Order> getAllOrders();

}
