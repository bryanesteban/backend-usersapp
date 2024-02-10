package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Role;
import com.bryan.backend.usersapp.backendusersapp.models.entities.User;
import com.bryan.backend.usersapp.backendusersapp.models.request.userRequest;
import com.bryan.backend.usersapp.backendusersapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
       return (List<User>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        String passwordBc = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordBc);

        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_USER"));
        return repository.save(user);
    }

    @Override
    @Transactional
    public void remove(Long id) {
       repository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<User> update(userRequest user, Long id) {
         Optional<User> o = this.findById(id);
         User userOptional = null;
        if(o.isPresent()){
            User userDb = o.orElseThrow();
            userDb.setUsername(user.getUsername());
            userDb.setEmail(user.getEmail());
            userOptional = this.save(userDb);
        }
        return Optional.ofNullable(userOptional);
    }

    
    

}
