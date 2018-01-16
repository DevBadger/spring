package com.devbadger.securityapp.service;

import com.devbadger.security.model.User;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/8/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
public interface SecurityProviderService {

    String generateJWT(User user);
}
