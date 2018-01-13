package com.devbadger.gatewayapp;

import icndb.service.IcndbServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Badger on 1/13/18.
 */
@Configuration
@Import(value = { IcndbServiceConfig.class })
public class GatewayConfiguration extends WebMvcConfigurerAdapter {

}
