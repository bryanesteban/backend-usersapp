package com.bryan.backend.usersapp.backendusersapp.models.DTO.mapper;

public class DtoMapperUser {

    private static DtoMapperUser mapper;

    private DtoMapperUser(){

    }

    private static DtoMapperUser getInstance()
    {
        mapper = new DtoMapperUser();
        return mapper;
    }
}
