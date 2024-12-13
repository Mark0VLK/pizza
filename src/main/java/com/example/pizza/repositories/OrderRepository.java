package com.example.pizza.repositories;

import com.example.pizza.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByUserLoginOrderByCreatedDesc(String login);
}
