package com.bryan.backend.usersapp.backendusersapp.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JpaUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(!username.equals("admin")){
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema!", username));
        }

        List<GrantedAuthorities> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username, "12345", true, true,true, true, authorities);

    }

}
