package com.example.pizza.service;

import com.example.pizza.request.LocationCreateRequest;
import com.example.pizza.response.LocationResponse;

import java.util.List;


public interface LocationService {

    /**
     * This method deletes a location by ID
     *
     * @param id a unique location ID.
     * @return the deleted LocationResponse object containing information entity if successfully deleted
     */
    LocationResponse deleteById(Long id);

    /**
     * This method creates a new location in the system.
     *
     * @param locationCreateRequest the LocationCreateRequest object containing information about the location
     *                              to create.
     * @return the created LocationResponse object.
     */
    LocationResponse create(LocationCreateRequest locationCreateRequest);

    /**
     * This method updates information about an existing location in the system.
     *
     * @param id                    the ID of location to update.
     * @param locationCreateRequest the LocationCreateRequest object containing information about
     *                              the location to update.
     * @return the updated LocationResponse object
     */
    LocationResponse update(Long id, LocationCreateRequest locationCreateRequest);

    /**
     * This method returns the location by its ID.
     *
     * @param id a unique location ID.
     * @return the LocationResponse object
     */
    LocationResponse getLocationById(Long id);

    /**
     * This method returns a list of all locations in the system.
     *
     * @return list of LocationResponse objects
     */
    List<LocationResponse> getAllLocations();

}