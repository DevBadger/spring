package com.devbadger.graphqlapp.datafetcher;

import com.devbadger.graphqlapp.service.GatewayService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JokeDataFetcher implements DataFetcher<Optional<Joke>>{
    private GatewayService gatewayService;

    @Autowired
    public JokeDataFetcher(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @Override
    public Optional<Joke> get(DataFetchingEnvironment environment) {
        Integer id = environment.getArgument("id");
        return gatewayService.getJoke(id);
    }
}
