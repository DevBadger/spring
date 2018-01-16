package com.devbadger.serviceapp;

import com.devbadger.service.common.model.ServiceObjectMapper;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@EnableAutoConfiguration
@Configuration
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({ "com.devbadger.service"})
@EnableFeignClients
@Import({ServiceConfig.class})
public class ServiceApp extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ServiceApp.class);
	}

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(ServiceApp.class);
		sa.run(args);
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingMappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter(new ServiceObjectMapper());
	}
}
