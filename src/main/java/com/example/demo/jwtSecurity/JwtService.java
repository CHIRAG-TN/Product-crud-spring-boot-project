package com.example.demo.jwtSecurity;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	
	public JwtService() {
		super();
	}

	
	public JwtService(String secret) {
		super();
		this.secret = secret;
	}


	private String secret="odfnjo%^GF5876Gh67edvwufhbekrgfehgr&^vdshjc";
	
	public String generateToken(User user) {
		
		return Jwts.builder()
				   .subject(user.getUsername())
				   .claim("role", user.getRole())
				   .issuedAt(new Date())
				   .expiration(new Date(System.currentTimeMillis() + 1000*60*15))
				   .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
				   .compact();
	}


	public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith(
                    Keys.hmacShaKeyFor(secret.getBytes())
                )
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
