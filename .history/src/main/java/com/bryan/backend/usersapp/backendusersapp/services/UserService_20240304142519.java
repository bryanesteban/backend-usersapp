package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.UserDto;
import com.bryan.backend.usersapp.backendusersapp.models.entities.User;
import com.bryan.backend.usersapp.backendusersapp.models.request.userRequest;

public interface UserService {

    List<UserDto> findAll();

    Page<UserDto> findAll(Pageable pageable);
    
    Optional<UserDto> findById(Long id);

    UserDto save(User user);
    Optional<UserDto> update(userRequest user, Long id);

    void remove(Long id);

}
