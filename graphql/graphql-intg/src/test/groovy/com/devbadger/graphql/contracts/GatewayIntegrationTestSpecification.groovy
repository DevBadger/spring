package com.devbadger.graphql.contracts

import com.netflix.loadbalancer.Server
import com.netflix.loadbalancer.ServerList
import com.taskeasy.serviceapp.ServiceApp
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ActiveProfiles
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by Badger on 11/22/17.
 */
@SpringBootTest(classes = ServiceApp, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureStubRunner(workOffline = true, ids = "com.taskeasy:gateway-app:+:stubs:14552")
@ActiveProfiles("test")
class GatewayIntegrationTestSpecification extends Specification{
    def service = "http://localhost:13553"
    def restTemplate = new RestTemplate()
    def headers = new LinkedMultiValueMap<>() as MultiValueMap<String, String>

    // Load balancer with fixed server list for "local" pointing to wireMock
    //Picked up by @AutoConfigureStubRunner
    @Configuration
    static class LocalRibbonClientConfiguration {
        @Bean
        ServerList<Server> ribbonServerList() {
            new StaticServerList<>([new Server("localhost", 14552)].toList())
        }
    }
}
