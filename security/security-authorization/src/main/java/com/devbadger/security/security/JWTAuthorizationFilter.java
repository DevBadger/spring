package com.devbadger.security.security;

import com.devbadger.security.exception.SecurityAuthorizationException;
import com.devbadger.security.service.SecurityValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.devbadger.security.config.SecurityProperties.*;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/10/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */

@Component
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

    @Autowired
    SecurityValidationService validationService;

    @Autowired
    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {

        String jwt = getFlexJWTFromRequest(req);
        log.info("module='flex-security-authorization' method='doFilterInternal' jwt='" + jwt + "'");
        try {
            validationService.validateAndReturnFlexUser(jwt);
            log.debug("module='flex-security-authorization' method='doFilterInternal' jwt is good AUTHORIZED access.");
        } catch (SecurityAuthorizationException e) {
            log.error("module='flex-security-authorization' method='doFilterInternal' Exception  ",  e);
            // Setting the jwt to null will cause a 403 Unauthorized response to be returned (spring-security in action).
            // See details where creating the JwtAuthenticationToken with null "credentials" means not authorization.
            jwt = null;
        }
        validationService.setJWTOnSecurityContext(jwt);
        chain.doFilter(req, res);
    }

    private String getFlexJWTFromRequest(HttpServletRequest request) {

        String token = null;
        String header = request.getHeader(HEADER_AUTHORIZATION);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            token = request.getHeader(HEADER_AUTHORIZATION);
            if (token != null) {
               token = token.replace(TOKEN_PREFIX, "");
            }
        }
        return token;
    }
}
