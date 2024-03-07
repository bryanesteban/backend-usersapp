package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;
import com.bryan.backend.usersapp.backendusersapp.repositories.ClientRepository;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Page<ClientDTO> findAll(Pageable pageable) {
        
        Page<Client> clientPage = clientRepository.findAll(pageable);
        return clientPage.map(c -> ClientDTO.builder().setClient(c).build());

    }

    @Override
    public Optional<ClientDTO> findByIdentification(String identification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdentification'");
    }

    @Override
    public Optional<ClientDTO> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public Optional<ClientDTO> findByLastName(String lastName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLastName'");
    }

    @Override
    public ClientDTO save(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Client> update(Client Client, String identification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void remove(String identification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

}
