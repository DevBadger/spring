package com.devbadger.graphqlapp.datafetcher;

import com.devbadger.graphqlapp.service.GatewayService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JokeByIdDataFetcher implements DataFetcher<Joke>{
    private GatewayService gatewayService;

    @Autowired
    public JokeByIdDataFetcher(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @Override
    public Joke get(DataFetchingEnvironment environment) {
        Integer id = environment.getArgument("id");
        return gatewayService.getJokeById(id);
    }
}
