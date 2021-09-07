package com.journeyfy.journeyfytravelapplication.security.jwt;

import com.journeyfy.journeyfytravelapplication.security.services.UserDetailsImplementation;
import com.journeyfy.journeyfytravelapplication.users.Role;
import com.journeyfy.journeyfytravelapplication.users.User;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
@Slf4j
public class JwtUtils {

    @Value("${journeyfy.app.jwtSecret}")
    private String jwtSecret;

    @Value("${journeyfy.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Autowired
    UserRepository userRepository;

    public String generateJwtToken(UserDetailsImplementation userPrincipal) {
        return generateTokenFromUserName(userPrincipal.getUsername());
    }

    public String generateTokenFromUserName(String username) {
        User user = userRepository.findByUsername(username).get();
        Set<Role> authorities = user.getRoles();
        return Jwts.builder().setSubject(username).claim("roles", authorities)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);

        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
