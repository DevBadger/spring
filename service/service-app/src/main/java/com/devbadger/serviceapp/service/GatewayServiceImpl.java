package com.devbadger.serviceapp.service;

import com.devbadger.service.common.model.Joke;
import com.devbadger.serviceapp.client.GatewayClient;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Badger on 1/15/18.
 */
public class GatewayServiceImpl implements GatewayService{
    private final GatewayClient gatewayClient;

    public GatewayServiceImpl(GatewayClient gatewayClient) {
        this.gatewayClient = gatewayClient;
    }

    @Override
    public Optional<Joke> getJoke(Integer id) {
        return Optional.of(gatewayClient.getJoke(id));
    }

    @Override
    public Optional<Joke> getRandomJoke() {
        return Optional.of(gatewayClient.getRandomJoke());
    }

    @Override
    public Collection<Joke> getRandomJokes(Integer count) {
        return gatewayClient.getRandomJokes(count);
    }

    @Override
    public Collection<Joke> getAllJokes() {
        return gatewayClient.getAllJokes();
    }

    @Override
    public Collection<String> getCategories() {
        return gatewayClient.getCategories();
    }

    @Override
    public Integer getJokeCount() {
        return gatewayClient.getJokeCount();
    }
}
