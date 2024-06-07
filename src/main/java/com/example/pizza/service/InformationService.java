package com.example.pizza.service;

import com.example.pizza.model.Information;

import java.util.List;


public interface InformationService {

    Information getInformationById(Long id);
    List<Information> getAllInformations();

}
