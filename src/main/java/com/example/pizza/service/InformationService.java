package com.example.pizza.service;

import com.example.pizza.model.Information;
import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.request.information.InformationUpdateRequest;

import java.util.List;


public interface InformationService {

    /**
     * Deletes the information entity with the specified ID.
     *
     * @param id the ID of the information entity to delete.
     * @return the deleted information entity, or null if none is found with the specified ID.
     */
    Information deleteById(Long id);

    /**
     * Creates a new information entity based on the provided request data.
     *
     * @param informationCreateRequest the request data for creating the information entity.
     * @return the newly created information entity.
     */
    Information create(InformationCreateRequest informationCreateRequest);

    /**
     * Updates an existing information entity based on the provided update request data.
     *
     * @param informationUpdateRequest the request data for updating the information entity.
     * @return the updated information entity.
     */
    Information update(InformationUpdateRequest informationUpdateRequest);

    /**
     * Retrieves the information entity with the specified ID.
     *
     * @param id the ID of the information entity to retrieve.
     * @return the information entity with the specified ID, or null if none is found.
     */
    Information getInformationById(Long id);

    /**
     * Retrieves all information entities.
     *
     * @return a list of all information entities.
     */
    List<Information> getAllInformation();

}
