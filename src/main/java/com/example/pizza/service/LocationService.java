package com.example.pizza.service;

import com.example.pizza.model.Location;

import java.util.List;


public interface LocationService {

    Location getLocationById(Long id);

    List<Location> getAllLocations();

}