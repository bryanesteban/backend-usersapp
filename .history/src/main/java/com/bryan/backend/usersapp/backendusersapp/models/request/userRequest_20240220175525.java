package com.bryan.backend.usersapp.backendusersapp.models.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class userRequest {


    @NotBlank
    @Column(name = "username", unique = true)
    @Size(min = 4, max = 30)
    private String username;
    
    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;

    private boolean admin;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
