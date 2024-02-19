package com.bryan.backend.usersapp.backendusersapp.models.DTO.mapper;

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


}
