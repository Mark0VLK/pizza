package com.example.pizza.service;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.user.UserCreateRequest;
import com.example.pizza.response.UserResponse;

import java.util.List;


public interface UserService {

    /**
     * Adds a location to a user.
     *
     * @param userId     the ID of the user to which the location will be added
     * @param locationId the ID of the location to be added to the user
     * @return the updated UserResponse object with the new location added
     */
    UserResponse addUserLocation(Long userId, Long locationId);

    /**
     * This method allows for both permanent and soft deletion of users based on the forever flag.
     *
     * @param id      a unique user ID.
     * @param deleteMode the mode indicating whether to delete the user permanently or softly
     * @return the deleted UserResponse object.
     */
    UserResponse deleteById(Long id, DeleteMode deleteMode);

    /**
     * This method creates a new user in the system.
     *
     * @param userCreateRequest the UserCreateRequest object containing information about the user
     *                          to create.
     * @return the created UserResponse object.
     */
    UserResponse create(UserCreateRequest userCreateRequest);

    /**
     * This method updates information about an existing user in the system.
     * @param id the ID of user to update
     * @param userCreateRequest the UserCreateRequest object containing information for updating the user.
     * @return the updated UserResponse object.
     */
    UserResponse update(Long id, UserCreateRequest userCreateRequest);

    /**
     * This method returns the user by his ID.
     *
     * @param id a unique user ID.
     * @return the UserResponse object
     */
    UserResponse getUserById(Long id);

    /**
     * This method returns a list of all users from the system.
     *
     * @return list of all UserResponse objects
     */
    List<UserResponse> getAllUsers();

}
