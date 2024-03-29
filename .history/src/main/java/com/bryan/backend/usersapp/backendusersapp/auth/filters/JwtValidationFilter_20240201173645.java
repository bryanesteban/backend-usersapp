package com.bryan.backend.usersapp.backendusersapp.auth.filters;

import java.io.IOException;
import java.util.Base64;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);

    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain)
            throws IOException, ServletException {

                String header = request.getHeader("Authorization");

                if(header == null || !header.startsWith("Bearer ")){
                    chain.doFilter(request, response);
                    return;
                }
                
        String token = header.replace("Bearer ", "");
        byte[] tokenDecodeBytes = Base64.getDecoder().decode(token);
        String tokenDecode = new String(tokenDecodeBytes);

        String [] tokenArr = tokenDecode.split(".");
        

    }
    

}
