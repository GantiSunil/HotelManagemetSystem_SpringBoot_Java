package com.sunil.serviceimpl;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sunil.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl  implements JwtService{
	
	String secretKey = "";
	
	public JwtServiceImpl() throws Exception
	{
		KeyGenerator  keyGenerator =  KeyGenerator.getInstance("HmacSHA256");
		
		SecretKey secertkey1 = keyGenerator.generateKey();
		
		secretKey = Base64.getEncoder().encodeToString(secertkey1.getEncoded());
		
	} 

	@Override
	public String getJwtToken(String username) {
		
		Map<String,Object> claims = new HashMap<String,Object>();
		
		
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 108000))
				.and()
				.signWith(getKey())
				.compact();
	}
	
	public SecretKey getKey() {
		
		byte[] keyValue = Decoders.BASE64.decode(secretKey);
		
		return Keys.hmacShaKeyFor(keyValue);
		
	}
	
	// ---------------- Jwt  Validation Logic ---------------------
	
	public String extractUserName(String jwtToken) 
	{
		
		
		return extractClaim(jwtToken,Claims::getSubject);
	}
	
	
	public <T> T extractClaim(String jwtToken,Function<Claims,T> CalimResolver)
	{
		
		final Claims claims = extractAllClaims(jwtToken);
		
		return CalimResolver.apply(claims);
	} 
	
	
	public  Claims extractAllClaims(String jwtToken) {
		
		
		return Jwts.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(jwtToken)
				.getPayload();
		
	}

	@Override
	public boolean validateToken(String jwtToken, UserDetails userDetails) {
		
		final String userName = extractUserName(jwtToken);
		
		
		return (userName.equals(userDetails.getUsername()) && ! isTokenExpired(jwtToken));
	}
	
	
	private boolean isTokenExpired(String jwtToken) 
	{
		
		
		return extractExpiration(jwtToken).before(new Date());
	}
	
	private Date extractExpiration(String jwtToken) {
		
		
		return extractClaim(jwtToken,Claims::getExpiration);
	}
	

}
