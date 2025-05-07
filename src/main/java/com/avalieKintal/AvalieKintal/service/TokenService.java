package com.avalieKintal.AvalieKintal.service;

import com.avalieKintal.AvalieKintal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder jwtEncoder;

    public String generateToken(User user) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("AvalieKintal")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(86400)) //24hr
                .subject(user.getId().toString())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
