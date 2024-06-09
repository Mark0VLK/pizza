package com.example.pizza.repositories;

import com.example.pizza.model.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishOrderRepository extends JpaRepository<DishOrder, Long> {
}
