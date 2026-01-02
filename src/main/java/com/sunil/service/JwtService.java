package com.sunil.service;

import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {
	
	
	public String getJwtToken(String username);
	
	//Jwt Validation Logic
	
	public String extractUserName(String jwtToken); 
	
	public <T> T extractClaim(String jwtToken,Function<Claims,T> CalimResolver);
	
	
	public boolean validateToken(String jwtToken,UserDetails userDetails);

}
