package com.example.pizza.service;

import com.example.pizza.model.User;
import com.example.pizza.request.user.UserCreateRequest;
import com.example.pizza.request.user.UserUpdateRequest;

import java.util.List;


public interface UserService {
    User create(UserCreateRequest userCreateRequest);

    User update(UserUpdateRequest userUpdateRequest);

    User getUserById(Long id);

    List<User> getAllUsers();

}
