package com.devbadger.serviceapp;

import com.devbadger.serviceapp.client.GatewayClient;
import com.devbadger.serviceapp.service.GatewayService;
import com.devbadger.serviceapp.service.GatewayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Badger on 1/15/18.
 */
@Configuration
public class ServiceConfig {

    @Bean
    public GatewayService productService(GatewayClient flexGatewayClient) {
        return new GatewayServiceImpl(flexGatewayClient);
    }
}
