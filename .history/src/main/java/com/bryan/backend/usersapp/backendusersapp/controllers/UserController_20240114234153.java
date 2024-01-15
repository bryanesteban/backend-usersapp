package com.bryan.backend.usersapp.backendusersapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.backend.usersapp.backendusersapp.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("path")
    public SomeData getMethodName(@RequestParam String param) {
        return new SomeData();
    }
    
    prublic List<User> list(){
        return service.findAll();
    }
}
