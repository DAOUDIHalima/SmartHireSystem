package org.shp.user_service.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.shp.user_service.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.shp.user_service.services.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.io.Decoders;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${shp.app.jwtSecret}")
    private String jwtSecret;

    @Value("${shp.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    // Generate JWT token using the user's principal details
    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername()) // Set username as the subject
                .setIssuedAt(new Date()) // Token issuance time
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) // Set expiration time
                .signWith(key(), SignatureAlgorithm.HS256) // Sign token with the secret key
                .compact();
    }

    // Helper method to generate the key using the secret
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)); // Use BASE64-decoded secret
    }

    // Extract the username (subject) from the JWT token
    public String getUserNameFromJwtToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key()) // Set the secret key for parsing
                    .build()
                    .parseClaimsJws(token) // Parse the token
                    .getBody()
                    .getSubject(); // Extract the subject (username)
        } catch (JwtException e) {
            logger.error("Failed to extract username from JWT: {}", e.getMessage());
            return null;
        }
    }

    // Validate the JWT token
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authToken); // Parse the token
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
