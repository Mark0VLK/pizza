package com.example.pizza.service;

import com.example.pizza.model.Information;
import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.request.information.InformationUpdateRequest;

import java.util.List;


public interface InformationService {

    Information create(InformationCreateRequest informationCreateRequest);

    Information update(InformationUpdateRequest informationUpdateRequest);

    Information getInformationById(Long id);

    List<Information> getAllInformation();

}
