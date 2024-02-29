package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bryan.backend.usersapp.backendusersapp.models.IUser;
import com.bryan.backend.usersapp.backendusersapp.models.DTO.UserDto;
import com.bryan.backend.usersapp.backendusersapp.models.DTO.mapper.DtoMapperUser;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Role;
import com.bryan.backend.usersapp.backendusersapp.models.entities.User;
import com.bryan.backend.usersapp.backendusersapp.models.request.userRequest;
import com.bryan.backend.usersapp.backendusersapp.repositories.RoleRepository;
import com.bryan.backend.usersapp.backendusersapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {

       List<User> users = (List<User>) repository.findAll();

       return users
                .stream()
                .map(u -> DtoMapperUser.builder().setUser(u).build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> findById(Long id) {

         return repository.findById(id).map( u ->  DtoMapperUser
            .builder()
            .setUser(u)
            .build());
    }

    @Override
    @Transactional
    public UserDto save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(getRoles(user));

        
        return DtoMapperUser.builder().setUser(repository.save(user)).build();
    } 

    @Override
    @Transactional
    public void remove(Long id) {
       repository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<UserDto> update(userRequest user, Long id) {
         Optional<User> o = repository.findById(id);
         User userOptional = null;
        if(o.isPresent()){

            User UerDb = o.orElseThrow();
            UerDb.setRoles(getRoles(user));

            User userDb = o.orElseThrow();
            userDb.setUsername(user.getUsername());
            userDb.setEmail(user.getEmail());
            userOptional = repository.save(userDb);
        }
        return Optional.ofNullable(DtoMapperUser.builder().setUser(userOptional).build());
    }

    private List<Role> getRoles(IUser user){

        Optional<Role> ou = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
       if(ou.isPresent()){
         roles.add(ou.orElseThrow());
       }
       if(user.isAdmin()){
        Optional<Role> oa = roleRepository.findByName("ROLE_ADMIN");
        if(oa.isPresent()){
            roles.add(oa.orElseThrow());
        }
       }
       
       return roles;
    }
    

}
