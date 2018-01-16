package com.devbadger.security.service;

import com.devbadger.security.exception.SecurityAuthorizationException;
import com.devbadger.security.model.JwtAuthenticationToken;
import com.devbadger.security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/13/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
@Service
public class SecurityValidationServiceImpl implements SecurityValidationService {

    private static final Logger log = LoggerFactory.getLogger(SecurityValidationServiceImpl.class);

    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.expiration}")
    private long expiration;

    @Value("${security.jwt.notBefore}")
    private long notBefore;


    @Override
    public User validateAndReturnFlexUser(String jwt) throws SecurityAuthorizationException {

        User flexUser;

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret.getBytes())
                    .parseClaimsJws(jwt)
                    .getBody();

            flexUser = getUser(claims);
        } catch (Exception e) {
             throw new SecurityAuthorizationException("JWT could not be parsed. Exception : " + e);
        }

        return flexUser;
    }

    private User getUser(Claims claims) {
        User flexUser = new User();

        flexUser.setSessionId((String) claims.get("sessionId"));
        flexUser.setStoreId((String) claims.get("storeId"));
        flexUser.setRepId((String) claims.get("repId"));

        return flexUser;
    }

    @Override
    public void setJWTOnSecurityContext(String token) {

        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(token);
        SecurityContextHolder.getContext().setAuthentication(jwtAuthenticationToken);
    }

    @Override
    public String getJWTFromSecurityContext() {

            String jwt = "";

            try {
                JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
                jwt = jwtAuthenticationToken.getToken();
                if (jwt == null || jwt.isEmpty())
                    throw new SecurityAuthorizationException("jwt missing from the SecurityContextHolder context.");

            } catch (Exception e) {
                log.error("module='flex-security-authorization' method='getJWTFromSecurityContext' ", e);

            }

        return jwt;
    }

//    // TODO validate
//    private boolean createPublicClaims() {
//        Claims claims = Jwts.claims();
//// TODO
////        claims.setExpiration(new Date(System.currentTimeMillis() + expiration));
////        claims.setNotBefore(new Date(System.currentTimeMillis() - notBefore));
//
//        return claims;
//    }
}
