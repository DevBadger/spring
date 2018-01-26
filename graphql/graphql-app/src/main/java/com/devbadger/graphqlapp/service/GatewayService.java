package com.devbadger.graphqlapp.service;

import model.Joke;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Badger on 1/15/18.
 */
public interface GatewayService {
    Joke getJokeById(Integer id);
    Joke getRandomJoke();
    Collection<Joke> getRandomJokes(Integer count);
    Collection<Joke> getAllJokes();
    Collection<String> getCategories();
    Integer getJokeCount();
}
