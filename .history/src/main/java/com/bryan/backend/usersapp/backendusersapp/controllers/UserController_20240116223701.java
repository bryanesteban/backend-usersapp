package com.bryan.backend.usersapp.backendusersapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.backend.usersapp.backendusersapp.models.entities.User;
import com.bryan.backend.usersapp.backendusersapp.services.UserService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable (name ="id") Long idUser){
        Optional<User> userOptional = service.findById(idUser);
        
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping 
    public ResponseEntity<?> create (@RequestBody User user){
        User userDB = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, Long id){
        Optional<User> o = service.findById(id);
        if(o.isPresent()){
            User userDb = o.orElseThrow();
            userDb.setUsername(user.getUsername());
            userDb.setEmail(user.getEmail());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.userDb);
    }
}
