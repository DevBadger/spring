package com.devbadger.securityapp.controller;

import com.devbadger.security.model.User;
import com.devbadger.securityapp.service.SecurityProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    private static final Logger log = LoggerFactory.getLogger(TokenController.class);

    @Autowired
    SecurityProviderService securityService;

    public TokenController(SecurityProviderService securityService) {
        this.securityService = securityService;
    }

    @PostMapping
    public ResponseEntity<String> generateJWT(@RequestBody final User user) {

        log.info("module='flex-security-app' endpoint='/token' class='TokenController' method='generateJWT' user='" + user + "'");

        ResponseEntity<String> tokenResponse;

        try {
            String jwt = securityService.generateJWT(user);
            tokenResponse = new ResponseEntity<>(jwt, HttpStatus.OK);

            log.info("module='flex-security-app' token created.");

        } catch (Exception e) {
            log.error("module='flex-security-app' token NOT created. " + e);

            // Good security practice is not to give any hint that an error occurred.
            // The 404 response is sufficient to notify client of the error.
            log.error("module='flex-security-app' returned HttpStatus.NOT_FOUND 404 intentionally for a invalid request.");
            tokenResponse = new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        return tokenResponse;
    }
}
