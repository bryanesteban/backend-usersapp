package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.UserDto;
import com.bryan.backend.usersapp.backendusersapp.models.entities.User;
import com.bryan.backend.usersapp.backendusersapp.models.request.userRequest;

public interface UserService {

    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    UserDto save(User user);
    Optional<UserDto> update(userRequest user, Long id);

    void remove(Long id);

}
