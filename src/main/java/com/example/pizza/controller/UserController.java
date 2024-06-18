package com.example.pizza.controller;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.user.UserUpdateRequest;
import com.example.pizza.response.UserResponse;
import com.example.pizza.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponses = userService.getAllUsers();
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id,
                                               @RequestBody UserUpdateRequest userUpdateRequest) {
        UserResponse userResponse = userService.update(id, userUpdateRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable Long id,
                                               @RequestParam(value = "deleteMode", defaultValue = "SOFT")
                                               DeleteMode deleteMode) {
        UserResponse userResponse = userService.deleteById(id, deleteMode);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/{userId}/{locationId}")
    public ResponseEntity<UserResponse> addLocation(@PathVariable Long userId, @PathVariable Long locationId) {
        UserResponse userResponse = userService.addUserLocation(userId, locationId);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
