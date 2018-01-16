package com.devbadger.gatewayapp;

import com.devbadger.gatewayapp.config.AppConfig;
import com.devbadger.security.config.SecurityAuthorizationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Configuration
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.devbadger"})
@ComponentScan({ "com.devbadger", "com.devbadger.security"})
@Import(value = {AppConfig.class, SecurityAuthorizationConfig.class})
public class GatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApp.class, args);
	}
}
