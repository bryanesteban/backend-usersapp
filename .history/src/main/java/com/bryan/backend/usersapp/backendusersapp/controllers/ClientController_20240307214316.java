package com.bryan.backend.usersapp.backendusersapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.services.ClientServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clients")
@CrossOrigin(originPatterns = "*")
public class ClientController {

    @Autowired
    private ClientServiceImpl service;

    @GetMapping("/page/{page}")
    public Page<ClientDTO> list(@RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return service.findAll(pageable);
    }

    @GetMapping("/{identification}")
    public ResponseEntity<?> show(@PathVariable (name = "identification") String identification) {
        return new String();
    }
    
    

}
