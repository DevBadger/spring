package com.devbadger.serviceapp.config;

import com.devbadger.service.common.model.ServiceObjectMapper;
import com.devbadger.serviceapp.client.GatewayClient;
import com.devbadger.serviceapp.service.GatewayService;
import com.devbadger.serviceapp.service.GatewayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by Badger on 1/15/18.
 */
@Configuration
public class AppConfig {

    @Bean
    public GatewayService productService(GatewayClient gatewayClient) {
        return new GatewayServiceImpl(gatewayClient);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingMappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(new ServiceObjectMapper());
    }
}
