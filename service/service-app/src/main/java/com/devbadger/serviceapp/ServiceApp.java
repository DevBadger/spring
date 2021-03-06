package com.devbadger.serviceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.devbadger"})
@ComponentScan({ "com.devbadger"})
public class ServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(ServiceApp.class, args);
	}
}
