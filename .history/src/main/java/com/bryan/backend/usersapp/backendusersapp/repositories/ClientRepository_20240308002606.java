package com.bryan.backend.usersapp.backendusersapp.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;


public interface ClientRepository
        extends CrudRepository<Client,Long> {

            Page<Client> findAll(Pageable pageable); 

            Optional<Client> findByIdentification(String identification);

            //@Query("select u from client u where u.name=?1 or u.lastname=?1")
            //Optional<Client> getClientByNameAndLastname(String nameClient);
            

            Optional<Client> deleteByIdentification(String identification);


            

}
