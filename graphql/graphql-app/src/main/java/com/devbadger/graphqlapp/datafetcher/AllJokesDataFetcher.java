package com.devbadger.graphqlapp.datafetcher;

import com.devbadger.graphqlapp.service.GatewayService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AllJokesDataFetcher implements DataFetcher<Collection<Joke>> {
    private GatewayService gatewayService;

    @Autowired
    public AllJokesDataFetcher(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @Override
    public Collection<Joke> get(DataFetchingEnvironment environment) {
        return gatewayService.getAllJokes();
    }
}
