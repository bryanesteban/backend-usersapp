package com.bryan.backend.usersapp.backendusersapp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.bryan.backend.usersapp.backendusersapp.auth.filters.JwtAuthenticationFilter;
import com.bryan.backend.usersapp.backendusersapp.auth.filters.JwtValidationFilter;

import io.jsonwebtoken.lang.Arrays;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/users").permitAll()
            .requestMatchers(HttpMethod.GET, "/users/{id}").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, "/users").hasAnyRole( "ADMIN")
            //.requestMatchers("/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/users/{id}").hasAnyRole( "ADMIN")
            .requestMatchers(HttpMethod.PUT, "/users/{id}").hasAnyRole( "ADMIN")
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
            .addFilter(new JwtValidationFilter(authenticationConfiguration.getAuthenticationManager()))
            .csrf(config -> config.disable()) //se deshabilita porque la la logica va en react.
            .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //control de la session
            .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        config.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "PUT"));
        config.setAllowedMethods(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);
    }
}
