package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.bryan.backend.usersapp.backendusersapp.models.entities.User;
import com.bryan.backend.usersapp.backendusersapp.models.entities.userRequest;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);
    Optional<User> update(userRequest user, userRequest id);

    void remove(Long id);

}
