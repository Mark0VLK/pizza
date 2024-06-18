package com.example.pizza.mapper;

import com.example.pizza.model.User;
import com.example.pizza.request.user.UserRegisterRequest;
import com.example.pizza.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User createRequestToUser(UserRegisterRequest userRegisterRequest);

    UserResponse userToResponse(User user);

    List<UserResponse> usersToResponses(List<User> users);
}
