package com.bryan.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "identification", unique = true)
    @Size(min = 10, max = 20)
    private String identification;

    @NotBlank
    @Column(name = "name")
    @Size(min = 5, max = 30)
    private String name;

    @NotBlank
    @Column(name = "lastName")
    @Size(min = 5, max = 30)
    private String lastname;

    @NotBlank
    @Column(name = "address")
    @Size(min = 5, max = 500)
    private String address;

    @NotBlank
    @Column(name = "phoneNumber")
    @Size(max = 20)
    private String phoneNumber;


    @Column(name = "email")
    @Size(max = 20)
    private String email;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    

    





}
