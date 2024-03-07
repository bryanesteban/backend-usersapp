package com.bryan.backend.usersapp.backendusersapp.models.DTO;

import java.util.Date;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientDTO {


    private String identification;
    private String name;
    private String lastname;
    private String address;
    private String phoneNumber;
    private String email;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateBirthday;

    

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateBegin;

    private Client client;

    public static ClientDTO builder ()
    {
        return new ClientDTO();
    }

    public ClientDTO setClient(Client client){

        this.client = client;
        return this;
    }

    
    ClientDTO(){

    }

    public ClientDTO(String identification, String name, String lastname, String address, String phoneNumber,
    String email, Date dateBirthday, Date dateBegin) {
    this.identification = identification;
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.dateBirthday = dateBirthday;
    this.dateBegin = dateBegin;
    }

    public ClientDTO build(){
        
        if( client == null){
            throw new RuntimeException("Debe pasar el entity Client!");
        }
        return new ClientDTO(client.getIdentification()
                            ,client.getName()
                            ,client.getLastname()
                            ,client.getAddress()
                            ,client.getPhoneNumber()
                            ,client.getEmail()
                            ,client.getDateBegin()
                            ,client.getDateBirthday());
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    
}
