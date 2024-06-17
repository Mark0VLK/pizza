package com.example.pizza.service.impl;

import com.example.pizza.request.location.LocationCreateRequest;
import com.example.pizza.request.location.LocationUpdateRequest;
import com.example.pizza.response.LocationResponse;
import com.example.pizza.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Override
    public LocationResponse deleteById(Long id) {

        return null;
    }

    @Override
    public LocationResponse create(LocationCreateRequest locationCreateRequest) {

        return null;
    }

    @Override
    public LocationResponse update(Long id, LocationUpdateRequest locationUpdateRequest) {

        return null;
    }

    @Override
    public LocationResponse getLocationById(Long id) {

        return null;
    }

    @Override
    public List<LocationResponse> getAllLocations() {

        return null;
    }
}
