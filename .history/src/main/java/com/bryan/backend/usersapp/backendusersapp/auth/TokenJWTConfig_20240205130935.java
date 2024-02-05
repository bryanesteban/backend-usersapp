package com.bryan.backend.usersapp.backendusersapp.auth;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenJWTConfig {

    //public final static String SECRET_KEY = "algun_token_con_alguna_frase_secreta";
    public final static String SECRET_KEY = "algun_token_con_alguna_frase_secreta";
    public final static String PREFIX_TOKEN = "Bearer ";
    public final static String HEADER_AUTHORIZATION = "Authorization";

    SecretKey key = Jwts.SIG.HS256.key().build();
    
}
