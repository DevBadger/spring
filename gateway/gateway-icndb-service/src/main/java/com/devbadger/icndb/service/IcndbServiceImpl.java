package com.devbadger.icndb.service;

import com.devbadger.icndb.client.IcndbFeignClient;
import model.Joke;
import model.GenericResponse;
import model.MultiJokeResponse;
import model.SingleJokeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Badger on 1/13/18.
 */
public class IcndbServiceImpl implements IcndbService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final IcndbFeignClient icndbFeignClient;

    public IcndbServiceImpl(IcndbFeignClient icndbFeignClient) {
        this.icndbFeignClient = icndbFeignClient;
    }

    @Override
    public int getJokeCount() {
        GenericResponse response = icndbFeignClient.getJokeCount();
        return (int) response.getValue();
    }

    @Override
    public Collection<String> getJokeCategories() {
        GenericResponse response = icndbFeignClient.getJokeCategories();
        return (Collection<String>) response.getValue();
    }

    @Override
    public Optional<Joke> getJoke(Integer id) {
        SingleJokeResponse jokeResponse = icndbFeignClient.getJoke(id);
        return Optional.of(jokeResponse.getValue());
    }

    @Override
    public Optional<Joke> getRandomJoke() {
        SingleJokeResponse jokeResponse = icndbFeignClient.getRandomJoke();
        return Optional.of(jokeResponse.getValue());
    }

    @Override
    public Collection<Joke> getRandomJokes(Integer count) {
        MultiJokeResponse jokeResponse = icndbFeignClient.getRandomJokes(count);
        return jokeResponse.getValue();
    }
}
