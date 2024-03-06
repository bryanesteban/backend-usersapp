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
    @Size(min = 5, max = 20)
    private String phoneNumber;



}
