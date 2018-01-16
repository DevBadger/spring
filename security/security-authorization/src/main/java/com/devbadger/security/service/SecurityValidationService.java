package com.devbadger.security.service;

import com.devbadger.security.exception.SecurityAuthorizationException;
import com.devbadger.security.model.User;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/13/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
public interface SecurityValidationService {
    User validateAndReturnFlexUser(String jwt) throws SecurityAuthorizationException;
    void setJWTOnSecurityContext(String token);
    String getJWTFromSecurityContext();
    }
