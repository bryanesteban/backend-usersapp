package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

public interface ClientService {


    Page<ClientDTO> findAll(Pageable pageable);

    Optional<ClientDTO> findByIdentification(String identification);

    Optional<ClientDTO> findByNameAndLastName(String nameClient);

    ClientDTO save(Client client);
    Optional<ClientDTO> update(Client client, String identification);

    void remove(String identification);

    
    

}
