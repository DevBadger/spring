package com.devbadger.gatewayapp.config;

import com.devbadger.icndb.service.IcndbServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Badger on 1/15/18.
 */
@Configuration
@Import(value = {IcndbServiceConfig.class})
public class GatewayConfig {
}
