package com.devbadger.security.exception;

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 12/5/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
public class SecurityAuthorizationException extends Exception {

    public SecurityAuthorizationException() {
        super();
    }

    public SecurityAuthorizationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SecurityAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityAuthorizationException(String message) {
        super(message);
    }

    public SecurityAuthorizationException(Throwable cause) {
        super(cause);
    }
}
