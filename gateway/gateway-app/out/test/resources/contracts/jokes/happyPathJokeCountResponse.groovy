package jokes
import org.springframework.cloud.contract.spec.Contract

Contract.make{
    description("""
        Represents the successful joke count retrieve
        When : When sending request for joke count
        Then : number of current jokes is retrieved
        """)

    request { // (1)
        method ('GET') // (2)
        urlPath ('/icndb/api/v1/jokes/count') // (3)
    }

    response { // (4)
        status (200) // (5)
        headers{
            contentType(applicationJsonUtf8()) // (6)
        }

        body(558)
    }


/*
Generate Unit Test
==================
cd /Users/z002ngh/Projects/devbadger/spring/gateway && ./gradlew generateContractTests

================================================================
= From the Consumer perspective, when requesting health status =
================================================================
(1) - If the consumer sends a request
(2) - With the "GET" method
(3) - to the URL "/api/v1/health"
(4) - then the response will be sent with
(5) - status equal '200'
(6) - and plain text body equal to 'flex-gateway running'

============================================================================
= From the Producer's perspective, in the autogenerated producer-side test =
============================================================================
(1) - A request will be sent to the producer
(2) - With the "GET" method
(3) - to the URL "/api/v1/health"
(4) - then the test will assert if the response has been sent with
(5) - status equal '200'
(6) - and plain text body equal to 'flex-gateway running'
 */
}