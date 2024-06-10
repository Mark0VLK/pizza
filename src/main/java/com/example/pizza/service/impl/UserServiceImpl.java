package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.UserCreateRequest;
import com.example.pizza.response.UserResponse;
import com.example.pizza.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserResponse addUserLocation(Long userId, Long locationId) {

        return null;
    }

    @Override
    public UserResponse deleteById(Long id, DeleteMode deleteMode) {

        return null;
    }

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {

        return null;
    }

    @Override
    public UserResponse update(Long id, UserCreateRequest userCreateRequest) {

        return null;
    }

    @Override
    public UserResponse getUserById(Long id) {

        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return null;
    }
}
