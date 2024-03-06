package com.bryan.backend.usersapp.backendusersapp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;

public interface ClientService {


    Page<ClientDTO> findAll(Pageable pageable);

}
