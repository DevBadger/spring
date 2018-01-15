package com.devbadger.icndb.service;

import com.devbadger.icndb.client.IcndbFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Badger on 1/13/18.
 */
@Configuration
public class IcndbServiceConfig {

    @Bean
    public IcndbService icndbService(final IcndbFeignClient icndbFeignClient) {
        return new IcndbServiceImpl(icndbFeignClient);
    }
}
