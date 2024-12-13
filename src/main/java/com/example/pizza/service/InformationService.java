package com.example.pizza.service;

import com.example.pizza.request.information.InformationCreateRequest;
import com.example.pizza.request.information.InformationUpdateRequest;
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
     *
     * @param id                       the ID of the information entity to delete.
     * @param informationUpdateRequest the request object containing updated information entity data
     * @return the updated InformationResponse object
     */
    InformationResponse update(Long id, InformationUpdateRequest informationUpdateRequest);

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

    /**
     * This method searches for information about products belonging to the specified category
     *
     * @param name the name of the category to search for information items
     * @return a list of {@link InformationResponse} objects that belong to the specified category
     */
    List<InformationResponse> getInformationByCategoryName(String name);
}
