package com.bryan.backend.usersapp.backendusersapp.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

public interface ClientRepository
        extends CrudRepository<Client,Long> {

            Page<Client> findAll(Pageable pageable); 

            Optional<Client> findById(Long id);

            Optional<Client> findByName(String name);


            

}
