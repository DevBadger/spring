package com.devbadger.icndb.service;

import model.Joke;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Badger on 1/13/18.
 */
public interface IcndbService {
    Optional<Joke> getJoke(Integer id);
    Optional<Joke> getRandomJoke();
    Collection<Joke> getRandomJokes(Integer id);
    int getJokeCount();
    Collection<String> getJokeCategories();
}
