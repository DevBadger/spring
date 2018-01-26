//package com.devbadger.serviceapp.contracts
//
//import com.devbadger.serviceapp.ServiceApp
//import com.netflix.loadbalancer.Server
//import com.netflix.loadbalancer.ServerList
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.test.context.ActiveProfiles
//import org.springframework.util.LinkedMultiValueMap
//import org.springframework.util.MultiValueMap
//import org.springframework.web.client.RestTemplate
//import spock.lang.Specification
//
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT
//
///**
// * Created by Badger on 11/22/17.
// */
//@SpringBootTest(classes = ServiceApp, webEnvironment = DEFINED_PORT)
//@AutoConfigureStubRunner(workOffline = true, ids = "com.devbadger:gateway-app:+:stubs:14552")
//@ActiveProfiles("test")
//class GatewayIntegrationTestSpecification extends Specification{
//    def service = "http://localhost:13551"
//    def restTemplate = new RestTemplate()
//    def headers = new LinkedMultiValueMap<>() as MultiValueMap<String, String>
//
//    // Load balancer with fixed server list for "local" pointing to wireMock
//    //Picked up by @AutoConfigureStubRunner
//    @Configuration
//    static class LocalRibbonClientConfiguration {
//        @Bean
//        ServerList<Server> ribbonServerList() {
//            new StaticServerList<>([new Server("localhost", 14552)].toList())
//        }
//    }
//}
