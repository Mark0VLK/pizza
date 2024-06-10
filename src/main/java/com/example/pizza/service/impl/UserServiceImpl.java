package com.example.pizza.service.impl;

import com.example.pizza.model.User;
import com.example.pizza.request.user.UserCreateRequest;
import com.example.pizza.request.user.UserUpdateRequest;
import com.example.pizza.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User create(UserCreateRequest userCreateRequest) {

        return null;
    }

    @Override
    public User update(UserUpdateRequest userUpdateRequest) {

        return null;
    }

    @Override
    public User getUserById(Long id) {

        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return null;
    }
}
