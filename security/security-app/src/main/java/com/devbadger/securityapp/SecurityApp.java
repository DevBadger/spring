package com.devbadger.securityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@EnableEurekaClient
@SpringBootApplication
public class SecurityApp {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp.class, args);
	}
}
