package com.example.pizza.service;

import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.response.InformationResponse;

import java.util.List;


public interface InformationService {

    /**
     * Deletes the information entity with the specified ID.
     *
     * @param id the ID of the information entity to delete.
     * @return the deleted InformationResponse object containing information entity if successfully deleted
     */
    InformationResponse deleteById(Long id);

    /**
     * Creates a new information entity based on the provided request data.
     *
     * @param informationCreateRequest the InformationCreateRequest object containing information entity.
     * @return the created InformationResponse object
     */
    InformationResponse create(InformationCreateRequest informationCreateRequest);

    /**
     * Updates an existing information entity based on the provided update request data.
     * @param id the ID of the information entity to delete.
     * @param informationCreateRequest the InformationCreateRequest containing data for updating entity.
     * @return the updated InformationResponse object
     */
    InformationResponse update(Long id, InformationCreateRequest informationCreateRequest);

    /**
     * Retrieves the information entity with the specified ID.
     *
     * @param id the ID of the information entity to retrieve.
     * @return the InformationResponse object containing information entity with the specified ID
     */
    InformationResponse getInformationById(Long id);

    /**
     * Retrieves all information entities.
     *
     * @return a list of all InformationResponse objects.
     */
    List<InformationResponse> getAllInformation();

}
