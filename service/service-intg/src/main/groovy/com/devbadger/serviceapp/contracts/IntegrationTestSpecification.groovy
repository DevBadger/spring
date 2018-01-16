package com.devbadger.serviceapp.contracts

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

/**
 * Created by Badger on 11/22/17.
 */

class IntegrationTestSpecification extends Specification{
    def service = "http://localhost:13553"
    def restTemplate = new RestTemplate()
    def headers = new LinkedMultiValueMap<>() as MultiValueMap<String, String>

    // Load balancer with fixed server list for "local" pointing to wireMock
    //Picked up by @AutoConfigureStubRunner
    @Configuration
    static class LocalRibbonClientConfiguration {
        @Bean
        ServerList<Server> ribbonServerList() {
            new StaticServerList<>([new Server("localhost", 14553)].toList())
        }
    }
}
