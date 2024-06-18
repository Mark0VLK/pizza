package com.example.pizza.service.impl;

import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.LocationMapper;
import com.example.pizza.model.Location;
import com.example.pizza.repositories.LocationRepository;
import com.example.pizza.request.location.LocationCreateRequest;
import com.example.pizza.request.location.LocationUpdateRequest;
import com.example.pizza.response.LocationResponse;
import com.example.pizza.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public LocationResponse deleteById(Long id) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("location",id));
        locationRepository.deleteById(id);
        return locationMapper.locationToResponse(location);
    }

    @Override
    public LocationResponse create(LocationCreateRequest locationCreateRequest) {

        Location location = locationMapper.createRequestToLocation(locationCreateRequest);
        locationRepository.save(location);
        return locationMapper.locationToResponse(location);
    }

    @Override
    public LocationResponse update(Long id, LocationUpdateRequest locationUpdateRequest) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("location", id));
        updateLocationFields(location, locationUpdateRequest);
        locationRepository.save(location);
        return locationMapper.locationToResponse(location);
    }

    private void updateLocationFields(Location location, LocationUpdateRequest locationUpdateRequest){

        location.setCountry(locationUpdateRequest.country());
        location.setCity(locationUpdateRequest.city());
        location.setStreet(locationUpdateRequest.street());
        location.setHouse(locationUpdateRequest.house());
        location.setFloor(locationUpdateRequest.floor());
        location.setFlat(locationUpdateRequest.flat());
    }

    @Override
    public LocationResponse getLocationById(Long id) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("location", id));
        return locationMapper.locationToResponse(location);
    }

    @Override
    public List<LocationResponse> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locationMapper.locationsToResponses(locations);
    }
}
