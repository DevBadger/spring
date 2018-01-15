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
    //    Collection<String> getJokeCategories();
//    Integer getJokeCount();
//    Optional<Joke> getRandomJokeByCategory(Collection<String> categories);
//    Optional<Joke> getRandomJokeExclude(Collection<String> categories);
//    Collection<Joke> getRandomJokes(int count);
//    Collection<Joke> getRandomJokes(Collection<String> categories, int count, String firstName, String lastName);
//    Collection<Joke> getRandomJokesExclude(Collection<String> categories, int count, String firstName, String lastName);
}
