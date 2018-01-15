package com.devbadger.icndb.service;

import com.devbadger.icndb.client.IcndbFeignClient;
import model.Joke;
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

//    @Override
//    public Integer getJokeCount() {
//        return icndbFeignClient.getJokeCount();
//    }
//
//    @Override
//    public Collection<String> getJokeCategories() {
//        return icndbFeignClient.getJokeCategories();
//    }
//
    @Override
    public Optional<Joke> getJoke(Integer id) {
        SingleJokeResponse jokeResponse = icndbFeignClient.getJoke(id);
        Optional<Joke> joke = Optional.empty();
        try{
            joke = Optional.of(jokeResponse.getValue());
        }catch(Exception e){
            LOGGER.error(e.getMessage());
        }
        return joke;
    }

    @Override
    public Optional<Joke> getRandomJoke() {
        SingleJokeResponse jokeResponse = icndbFeignClient.getRandomJoke();
        Optional<Joke> joke = Optional.empty();
        try{
            joke = Optional.of((Joke) jokeResponse.getValue());
        }catch(Exception e){
            LOGGER.error(e.getMessage());
        }
        return joke;
    }

    @Override
    public Collection<Joke> getRandomJokes(Integer count) {
        MultiJokeResponse jokeResponse = icndbFeignClient.getRandomJokes(count);
        return jokeResponse.getValue();
    }
//
//    @Override
//    public Optional<Joke> getRandomJokeByCategory(Collection<String> categories) {
//        JokeResponse response = icndbFeignClient.getRandomJokeByCategory(1, categories, null, null);
//        if(response.getValue() == null && response.getValue().isEmpty()){
//            return Optional.empty();
//        }else {
//            return Optional.of((Joke) response.getValue());
//        }
//    }
//
//    @Override
//    public Optional<Joke> getRandomJokeExclude(Collection<String> categories) {
//        JokeResponse response = icndbFeignClient.getRandomJokeExcludeCategory(1, categories, null, null);
//        if(response.getValue() == null && response.getValue().isEmpty()){
//            return Optional.empty();
//        }else {
//            return Optional.of((Joke) response.getValue());
//        }
//    }
//
//    @Override
//    public Collection<Joke> getRandomJokes(int count) {
//        return icndbFeignClient.getRandomJokeByCategory(count, null, null, null).getValue();
//    }
//
//    @Override
//    public Collection<Joke> getRandomJokes(Collection<String> categories, int count, String firstName, String lastName) {
//        return icndbFeignClient.getRandomJokeByCategory(count, categories, firstName, lastName).getValue();
//    }
//
//    @Override
//    public Collection<Joke> getRandomJokesExclude(Collection<String> categories, int count, String firstName, String lastName) {
//        return icndbFeignClient.getRandomJokeExcludeCategory(count, categories, firstName, lastName).getValue();
//    }
}
