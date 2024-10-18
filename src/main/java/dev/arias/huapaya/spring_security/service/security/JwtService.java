package dev.arias.huapaya.spring_security.service.security;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    public String generateToken(UserDetails userDetails, Map<String, Object> extraClaims) {
        String jwt = "";
        int minute = 3;
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expired = new Date((minute * 60 * 1000) + issuedAt.getTime());
        jwt = Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .subject(userDetails.getUsername())
                .issuedAt(issuedAt)
                .expiration(expired)
                .claims(extraClaims)
                .signWith(this.generateKey(), Jwts.SIG.HS256)
                .compact();
        return jwt;
    }

    public String extractUsername(String token) {
        return this.extractClaim(token).getSubject();
    }

    private SecretKey generateKey() {
        String secret_key = "secretkeyapplicationsecretkeyapplicationsecretkeyapplication";
        byte[] password = secret_key.getBytes();
        return Keys.hmacShaKeyFor(password);
    }

    private Claims extractClaim(String jwt) {
        return Jwts.parser().verifyWith(this.generateKey()).build().parseSignedClaims(jwt).getPayload();
    }

}
