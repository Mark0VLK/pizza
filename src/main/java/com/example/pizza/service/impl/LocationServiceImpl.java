package com.example.pizza.service.impl;

import com.example.pizza.model.Location;
import com.example.pizza.request.location.LocationCreateRequest;
import com.example.pizza.request.location.LocationUpdateRequest;
import com.example.pizza.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Override
    public Location create(LocationCreateRequest locationCreateRequest) {

        return null;
    }

    @Override
    public Location update(LocationUpdateRequest locationUpdateRequest) {

        return null;
    }

    @Override
    public Location getLocationById(Long id) {

        return null;
    }

    @Override
    public List<Location> getAllLocations() {

        return null;
    }
}
