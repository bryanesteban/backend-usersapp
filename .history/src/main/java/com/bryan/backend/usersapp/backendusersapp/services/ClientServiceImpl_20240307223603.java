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
        return clientRepository.findByIdentification(identification).map( u -> ClientDTO
        .builder()
        .setClient(u)
        .build());

    }

    @Override
    public Optional<ClientDTO> findByNameAndLastName(String nameClient) {
        return clientRepository.getClientByNameAndLastname(name).map( u -> ClientDTO
        .builder()
        .setClient(u)
        .build());
    }



    @SuppressWarnings("null")
    @Override
    public ClientDTO save(Client client) {
        return ClientDTO.builder().setClient(clientRepository.save(client)).build();
    }

    @Override
    public Optional<ClientDTO> update(Client client, String identification) {
        Optional<Client> o = clientRepository.findByIdentification(identification);
        Client clientOptional = null;

        if(o.isPresent()){
            Client clientDb = o.orElseThrow();

            clientDb.setName(client.getName());
            clientDb.setLastname(client.getLastname());
            clientDb.setAddress(client.getAddress());
            clientDb.setEmail(client.getAddress());
            clientDb.setPhoneNumber(client.getPhoneNumber());
            clientDb.setDateBirthday(client.getDateBirthday());
            clientDb.setDateBegin(client.getDateBegin());
        }

        return Optional.ofNullable(ClientDTO.builder().setClient(clientOptional).build());

    }

    @Override
    public void remove(String identification) {
        clientRepository.deleteByIdentification(identification);
    }

}
