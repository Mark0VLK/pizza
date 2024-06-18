package com.example.pizza.service.impl;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.mapper.UserMapper;
import com.example.pizza.model.Location;
import com.example.pizza.model.User;
import com.example.pizza.repositories.LocationRepository;
import com.example.pizza.repositories.UserRepository;
import com.example.pizza.request.user.UserCreateRequest;
import com.example.pizza.request.user.UserUpdateRequest;
import com.example.pizza.response.UserResponse;
import com.example.pizza.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse addUserLocation(Long userId, Long locationId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("user", userId));
        Location location = locationRepository.findById(locationId).orElseThrow(() ->
                new EntityNotFoundException("location", locationId));
        user.getLocations().add(location);
        return userMapper.userToResponse(userRepository.save(user));
    }

    @Override
    public UserResponse deleteById(Long id, DeleteMode deleteMode) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user", id));
        switch (deleteMode) {
            case HARD -> userRepository.deleteById(id);
            case SOFT -> {
                user.setIsDeleted(true);
                userRepository.save(user);
            }
        }
        return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        User user = userMapper.createRequestToUser(userCreateRequest);
        userRepository.save(user);
        return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse update(Long id, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user", id));
        updateUserFields(user, userUpdateRequest);
        userRepository.save(user);
        return userMapper.userToResponse(user);
    }

    private void updateUserFields(User user, UserUpdateRequest userUpdateRequest) {

        user.setName(userUpdateRequest.name());
        user.setSurname(userUpdateRequest.surname());
        user.setPhoneNumber(userUpdateRequest.phoneNumber());
        user.setEmail(userUpdateRequest.email());
        user.setPassword(userUpdateRequest.password());
        user.setBirthDate(userUpdateRequest.birthDate());
    }

    @Override
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user", id));
        return userMapper.userToResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> users = userRepository.findAll();
        return userMapper.usersToResponses(users);
    }
}
