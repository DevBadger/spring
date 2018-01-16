package com.devbadger.securityapp.service;

import com.devbadger.security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/13/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
@Service
public class APPSecurityValidationServiceImpl implements APPSecurityValidationService {

    @Override
    public User validateAndMore(String jwt) {

        User flexUser = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(com.devbadger.security.config.SecurityProperties.SECRET.getBytes())
                    .parseClaimsJws(jwt)
                    .getBody();

            flexUser = getUser(claims);
        } catch (Exception e) {
            System.out.println(e);
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
}
