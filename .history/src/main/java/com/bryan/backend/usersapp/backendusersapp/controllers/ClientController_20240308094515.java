package com.bryan.backend.usersapp.backendusersapp.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;
import com.bryan.backend.usersapp.backendusersapp.services.ClientServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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
        Optional<ClientDTO> clientOptional = service.findByIdentification(identification);

        if(clientOptional.isPresent()){
            return  ResponseEntity.ok(clientOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{nameClient}")
    public ResponseEntity<?> showforClient(@PathVariable (name = "nameClient") String nameClient) {
        Optional<ClientDTO> clientOptional = service.findByNameAndLastName(nameClient);

        if(clientOptional.isPresent()){
            return  ResponseEntity.ok(clientOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody Client client, BindingResult  result) {
        if(result.hasErrors()){
            return validation(result);
        }

        ClientDTO clientBD = service.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientBD);


    }

    @PutMapping("/{identification}")
    public ResponseEntity<?> update(@Valid @RequestBody  Client client,BindingResult result, @PathVariable String identification) {
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<ClientDTO> o = service.update(client, identification);
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{identification}")
    public ResponseEntity<?> remove(@PathVariable String identification){
        Optional<ClientDTO> o = service.findByIdentification(identification);
        if(o.isPresent()){
            service.remove(identification);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result){
        Map<String,String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo "+err.getField()+" "+err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
    
    
    
    

}
