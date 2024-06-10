package com.example.pizza.service;

import com.example.pizza.model.Location;
import com.example.pizza.request.location.LocationCreateRequest;
import com.example.pizza.request.location.LocationUpdateRequest;

import java.util.List;


public interface LocationService {

    Location create(LocationCreateRequest locationCreateRequest);

    Location update(LocationUpdateRequest locationUpdateRequest);

    Location getLocationById(Long id);

    List<Location> getAllLocations();

}