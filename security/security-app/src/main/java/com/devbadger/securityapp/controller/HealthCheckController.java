package com.devbadger.securityapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HealthCheck consistent with flex-service & flex-gateway
 *
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 12/1/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */
@RestController
@RequestMapping
public class HealthCheckController {

    @RequestMapping(value = "/api/v1/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("flex-security running");
    }

}
