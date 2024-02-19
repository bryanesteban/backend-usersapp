package com.bryan.backend.usersapp.backendusersapp.models.DTO.mapper;

import javax.management.RuntimeErrorException;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.UserDto;
import com.bryan.backend.usersapp.backendusersapp.models.entities.User;

public class DtoMapperUser {

    private static DtoMapperUser mapper;

    private User user;

    private DtoMapperUser(){
    }

    public static DtoMapperUser getInstance()
    {
        mapper = new DtoMapperUser();
        return mapper;
    }

    public DtoMapperUser setUser(User user) {
        this.user = user;
        return mapper;
    }

    public UserDto  build(){

        if( user == null){
            throw new RuntimeException("Debe pasar el entity User!");
        }
        UserDto userDto = new UserDto(this.user.getId(),user.getUsername(), user.getEmail());
    }

}
