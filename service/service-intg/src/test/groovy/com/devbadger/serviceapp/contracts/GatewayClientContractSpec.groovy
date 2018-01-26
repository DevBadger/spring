//package com.devbadger.serviceapp.contracts
//
//import org.springframework.http.HttpEntity
//import org.springframework.http.HttpStatus
//import spock.lang.Unroll
//
//import static org.springframework.http.HttpMethod.GET
//
///**
// * Created by Badger on 1/15/18.
// */
//class GatewayClientContractSpec extends GatewayIntegrationTestSpecification{
//    @Unroll("Expect '#expectedBody' when calling gatewayClient/icndb/api/v1/jokes/count")
//    "happyPathJokeCountResponse contract test"() {
//        given: "service endpoint"
//        def endpoint = "$service/icndb/api/v1/jokes/count"
//        when: "the endpoint is called"
//        def response = restTemplate.exchange(endpoint, GET, new HttpEntity<String>(headers), String)
//        then: "verify the status code = 200"
//        assert response.statusCode == HttpStatus.OK
//        and: "verify the body returns"
//        assert response.body == expectedBody
//        where:
//        num | expectedBody
//        1   | "558"
//    }
//
//    @Unroll("Expect '#expectedBody' when calling gatewayClient/icndb/api/v1/categories")
//    "happyPathCategoriesResponse contract test"() {
//        given: "service endpoint"
//        def endpoint = "$service/icndb/api/v1/categories"
//        when: "the endpoint is called"
//        def response = restTemplate.exchange(endpoint, GET, new HttpEntity<String>(headers), String)
//        then: "verify the status code = 200"
//        assert response.statusCode == HttpStatus.OK
//        and: "verify the body returns"
//        assert response.body == expectedBody
//        where:
//        num | expectedBody
//        1   | '["explicit","nerdy"]'
//    }
//}
