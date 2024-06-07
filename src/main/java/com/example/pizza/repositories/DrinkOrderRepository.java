package com.example.pizza.repositories;

import com.example.pizza.model.DrinkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkOrderRepository extends JpaRepository<DrinkOrder, Long> {
}
