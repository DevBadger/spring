package com.devbadger.gatewayapp.rest;

import com.devbadger.icndb.service.IcndbService;
import model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Badger on 1/15/18.
 */
@RestController
@RequestMapping("icndb/api/v1/")
public class IcndbController {

    private final IcndbService icndbService;

    @Autowired
    public IcndbController(IcndbService icndbService) {
        this.icndbService = icndbService;
    }

    @RequestMapping("jokes/random")
    public ResponseEntity<Joke> getRandomJoke(){
        Optional<Joke> optional = icndbService.getRandomJoke();
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
        Optional<Joke> optional = icndbService.getJoke(id);
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
        Collection<Joke> jokes = icndbService.getRandomJokes(count);
        return ResponseEntity.ok(jokes);
    }

    @RequestMapping("jokes/count")
    public int getJokeCount(){
        return icndbService.getJokeCount();
    }

    @RequestMapping("categories")
    public Collection<String> getJokeCategories(){
        return icndbService.getJokeCategories();
    }
}
