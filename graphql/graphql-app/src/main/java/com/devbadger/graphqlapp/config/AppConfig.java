package com.devbadger.graphqlapp.config;


import com.devbadger.graphqlapp.client.GatewayClient;
import com.devbadger.graphqlapp.datafetcher.AllJokesDataFetcher;
import com.devbadger.graphqlapp.datafetcher.JokeByIdDataFetcher;
import com.devbadger.graphqlapp.datafetcher.RandomJokeDataFetcher;
import com.devbadger.graphqlapp.service.GatewayService;
import com.devbadger.graphqlapp.service.GatewayServiceImpl;
import com.devbadger.graphqlapp.service.GraphQLService;
import com.devbadger.graphqlapp.service.GraphQLServiceImpl;
import model.ServiceObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by Badger on 1/15/18.
 */

@Configuration
public class AppConfig {

    @Bean
    public GatewayService gatewayService(GatewayClient gatewayClient){
        return new GatewayServiceImpl(gatewayClient);
    }

    @Bean
    public GraphQLService graphQLService(GatewayClient gatewayClient) {
        return new GraphQLServiceImpl(
                new AllJokesDataFetcher(gatewayService(gatewayClient)),
                new JokeByIdDataFetcher(gatewayService(gatewayClient)),
                new RandomJokeDataFetcher(gatewayService(gatewayClient)));
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingMappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(new ServiceObjectMapper());
    }
}
