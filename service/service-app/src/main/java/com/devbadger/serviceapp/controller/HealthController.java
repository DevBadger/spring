package com.devbadger.serviceapp.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Badger on 1/15/18.
 */
@RestController
public class HealthController {

    @RequestMapping(value = "health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("running");
    }

}
