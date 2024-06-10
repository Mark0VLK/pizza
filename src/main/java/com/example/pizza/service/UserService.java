package com.example.pizza.service;

import com.example.pizza.model.User;
import com.example.pizza.request.user.UserCreateRequest;
import com.example.pizza.request.user.UserUpdateRequest;

import java.util.List;


public interface UserService {

    /**
     * This method allows for both permanent and soft deletion of users based on the forever flag.
     *
     * @param id      a unique user ID.
     * @param forever a flag indicating how to delete a user (hard or soft)
     * @return a deleted user object.
     */
    User deleteById(Long id, boolean forever);

    /**
     * This method creates a new user in the system.
     *
     * @param userCreateRequest an object containing information about the user being created.
     * @return the created User object.
     */
    User create(UserCreateRequest userCreateRequest);

    /**
     * This method updates information about an existing user in the system.
     *
     * @param userUpdateRequest an object containing information for updating the user.
     * @return the updated User object.
     */
    User update(UserUpdateRequest userUpdateRequest);

    /**
     * This method returns the user by his ID.
     *
     * @param id a unique user ID.
     * @return the User object
     */
    User getUserById(Long id);

    /**
     * This method returns a list of all users from the system.
     *
     * @return list of users
     */
    List<User> getAllUsers();

}
