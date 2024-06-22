package com.example.pizza.repositories;

import com.example.pizza.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InformationRepository extends JpaRepository<Information, Long> {

    List<Information> getInformationByCategoryName(String name);
}
