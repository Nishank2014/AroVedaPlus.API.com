package com.user.auth.service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private String secretKey = "your-secret-key"; // Replace with a more secure key in production
    private long validityInMilliseconds = 3600000; // 1 hour

    // Generate JWT token for the user
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Subject is the username or user ID
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Extract Claims (payload) from token
    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Check if the token is expired
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Validate the token (check if it is expired and the username matches)
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
}
