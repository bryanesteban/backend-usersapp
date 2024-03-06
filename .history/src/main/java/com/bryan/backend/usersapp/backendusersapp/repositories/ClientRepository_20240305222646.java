package com.bryan.backend.usersapp.backendusersapp.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

public interface ClientRepository
        extends CrudRepository<Client,Long> {

            Page<ClientDTO> findAll(Pageable pageable); 

            Optional<Client> findByIdentification(String identification);

            Optional<Client> findByName(String name);

            Optional<Client> findByLastname(String lastname);


            

}
