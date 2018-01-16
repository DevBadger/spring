package com.devbadger.securityapp.service;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/13/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
public interface APPSecurityValidationService {
    com.devbadger.security.model.User validateAndMore(String jwt);
}
