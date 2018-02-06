package com.devbadger.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@EnableEurekaClient
@Configuration
@SpringBootApplication
public class GrpcApp {

	public static void main(String[] args) {
		SpringApplication.run(GrpcApp.class, args);
	}
}
