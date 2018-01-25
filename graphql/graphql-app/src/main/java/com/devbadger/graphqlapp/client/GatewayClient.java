package com.devbadger.graphqlapp.client;

import model.Joke;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created by Badger on 1/15/18.
 */
@FeignClient(name="gateway", configuration = GatewayClientConfig.class)
public interface GatewayClient {
    @RequestMapping("/rest/icndb/jokes/{id}")
    Joke getJoke(@RequestParam("id") final Integer id);

    @RequestMapping("/rest/icndb/jokes/random")
    Joke getRandomJoke();

    @RequestMapping("/rest/icndb/jokes/random/{count}")
    Collection<Joke> getRandomJokes(@RequestParam("count") final Integer count);

    @RequestMapping("/rest/icndb/categories")
    Collection<String> getCategories();

    @RequestMapping("/rest/icndb/jokes/count")
    Integer getJokeCount();

    @RequestMapping("/rest/icndb/jokes")
    Collection<Joke> getAllJokes();
}
