package com.bryan.backend.usersapp.backendusersapp.models.DTO.mapper;

import javax.management.RuntimeErrorException;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.UserDto;
import com.bryan.backend.usersapp.backendusersapp.models.entities.User;

public class DtoMapperUser {


    private User user;

    private DtoMapperUser(){
    }

    public static DtoMapperUser builder()
    {
        return new DtoMapperUser();
    }

    public DtoMapperUser setUser(User user) {
        this.user = user;
        return this;
    }

    public UserDto  build(){

        if( user == null){
            throw new RuntimeException("Debe pasar el entity User!");
        }
        return new UserDto(this.user.getId(),user.getUsername(), user.getEmail());
    }

}