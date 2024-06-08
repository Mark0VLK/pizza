package com.example.pizza.service;

import com.example.pizza.model.User;

import java.util.List;


public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

}
