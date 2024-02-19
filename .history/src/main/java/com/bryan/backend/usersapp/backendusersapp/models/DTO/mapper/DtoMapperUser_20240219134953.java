package com.bryan.backend.usersapp.backendusersapp.models.DTO.mapper;

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
}
