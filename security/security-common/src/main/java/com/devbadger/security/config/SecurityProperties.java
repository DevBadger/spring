package com.consensus.flexsecurity.config;


/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/8/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
public class SecurityProperties {

    public static final String SECRET = "flex-secret";
    public static final long EXPIRATION_TIME = 003_600_000; // 1 hour
    //public static final long EXPIRATION_TIME = 864_000_000; // 10 days

    // Used Auth0 2.0 mechanism 'Authorization Bearer '. Replace with cookie (POA to Tetris)?
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";

}
