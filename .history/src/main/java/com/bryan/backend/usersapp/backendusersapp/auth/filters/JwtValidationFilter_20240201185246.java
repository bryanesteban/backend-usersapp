package com.bryan.backend.usersapp.backendusersapp.auth.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

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
        String secret = tokenArr[0];
        String username = tokenArr[1];

        if("algun_token_con_alguna_frase_secreta".equals(secret)){

            List<GrantedAuthority> Authorities = new ArrayList<>();
            Authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, Authorities);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{

        }
        


    }
    

}
