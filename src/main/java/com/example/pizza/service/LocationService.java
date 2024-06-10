package com.example.pizza.service;

import com.example.pizza.model.Location;
import com.example.pizza.request.location.LocationCreateRequest;
import com.example.pizza.request.location.LocationUpdateRequest;

import java.util.List;


public interface LocationService {

    /**
     * This method deletes a location by ID
     *
     * @param id a unique location ID.
     * @return a deleted location object.
     */
    Location deleteById(Long id);

    /**
     * This method creates a new location in the system.
     *
     * @param locationCreateRequest an object containing information about the location being created.
     * @return the created Location object.
     */
    Location create(LocationCreateRequest locationCreateRequest);

    /**
     * This method updates information about an existing location in the system.
     *
     * @param locationUpdateRequest an object containing information for updating the location.
     * @return the updated Location object
     */
    Location update(LocationUpdateRequest locationUpdateRequest);

    /**
     * This method returns the location by its ID.
     *
     * @param id a unique location ID.
     * @return the Location object
     */
    Location getLocationById(Long id);

    /**
     * This method returns a list of all locations in the system.
     *
     * @return list of locations
     */
    List<Location> getAllLocations();

}