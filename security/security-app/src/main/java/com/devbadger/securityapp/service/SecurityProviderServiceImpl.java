package com.devbadger.securityapp.service;

import com.devbadger.security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/8/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
@Service
public class SecurityProviderServiceImpl implements SecurityProviderService {

    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.expiration}")
    private long expiration;

    @Value("${security.jwt.notBefore}")
    private long notBefore;


    @Override
    public String generateJWT(User user) {

        Claims claims = createClaim(user);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    private Claims createClaim(User user){

        Claims claims = createPublicClaims();

        // Add flex private claims to the jwt
        claims.put("sessionId", user.getSessionId());
        claims.put("storeId", user.getStoreId());
        claims.put("repId",  user.getRepId());

        return claims;
    }

    private Claims createPublicClaims() {
        Claims claims = Jwts.claims();
// TODO
//        claims.setExpiration(new Date(System.currentTimeMillis() + expiration));
//        claims.setNotBefore(new Date(System.currentTimeMillis() - notBefore));

        return claims;
    }
}
