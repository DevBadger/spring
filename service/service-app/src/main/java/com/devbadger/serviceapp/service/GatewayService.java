package com.devbadger.serviceapp.service;

import com.devbadger.service.common.model.Joke;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Badger on 1/15/18.
 */
public interface GatewayService {
    Optional<Joke> getJoke(Integer id);
    Optional<Joke> getRandomJoke();
    Collection<Joke> getRandomJokes(Integer count);
    Collection<Joke> getAllJokes();
    Collection<String> getCategories();
    Integer getJokeCount();
}
