package com.bryan.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

public interface ClientRepository
        extends CrudRepository<Client,Long> {

}
