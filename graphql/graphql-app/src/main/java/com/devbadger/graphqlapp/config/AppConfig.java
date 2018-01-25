package com.devbadger.graphqlapp.config;


import com.taskeasy.graphqlserviceapp.client.GatewayClient;
import com.taskeasy.graphqlserviceapp.service.GatewayService;
import com.taskeasy.graphqlserviceapp.service.GatewayServiceImpl;
import com.taskeasy.graphqlserviceapp.service.GraphQLService;
import com.taskeasy.graphqlserviceapp.service.GraphQLServiceImpl;
import com.taskeasy.graphqlserviceapp.service.datafetcher.AllJokesDataFetcher;
import com.taskeasy.graphqlserviceapp.service.datafetcher.JokeDataFetcher;
import com.taskeasy.graphqlserviceapp.service.datafetcher.RandomJokeDataFetcher;
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
                new JokeDataFetcher(gatewayService(gatewayClient)),
                new RandomJokeDataFetcher(gatewayService(gatewayClient)));
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingMappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(new ServiceObjectMapper());
    }
}
