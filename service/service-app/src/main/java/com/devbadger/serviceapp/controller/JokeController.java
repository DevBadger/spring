package com.devbadger.serviceapp.controller;

import com.devbadger.service.common.model.Joke;
import com.devbadger.serviceapp.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Badger on 1/15/18.
 */
@CrossOrigin // Evil solution
@RestController
@RequestMapping("icndb/api/v1/")
public class JokeController {

    private final GatewayService gatewayService;

    @Autowired
    public JokeController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @RequestMapping("jokes/random")
    public ResponseEntity<Joke> getRandomJoke(){
        Optional<Joke> optional = gatewayService.getRandomJoke();
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("jokes/{id}")
    public ResponseEntity<Joke> getJoke(
            @PathVariable("id") final Integer id
    ){
        Optional<Joke> optional = gatewayService.getJoke(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("jokes/random/{count}")
    public ResponseEntity<Collection<Joke>> getRandomJokes(
            @PathVariable("count") final Integer count
    ){
        Collection<Joke> jokes = gatewayService.getRandomJokes(count);
        return ResponseEntity.ok(jokes);
    }

    @RequestMapping("jokes/count")
    public ResponseEntity<Integer> getJokeCount(){
        Integer count = gatewayService.getJokeCount();
        return ResponseEntity.ok(count);
    }

    @RequestMapping("categories")
    public ResponseEntity<Collection<String>> getJokeCategories(){
        return ResponseEntity.ok(gatewayService.getCategories());
    }
}
