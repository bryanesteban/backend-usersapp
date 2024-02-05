package com.bryan.backend.usersapp.backendusersapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bryan.backend.usersapp.backendusersapp.models.entities.User;

public interface UserRepository 
       extends CrudRepository<User,Long>{

              Optional<User> findByUsername(String username);

              @Query("select u from User u where u.username")
              Optional<User> getUserByUsername(String username);
}
