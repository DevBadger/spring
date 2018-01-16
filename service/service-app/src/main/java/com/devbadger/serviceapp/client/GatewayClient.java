package com.devbadger.serviceapp.client;

import com.devbadger.service.common.model.Joke;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created by Badger on 1/15/18.
 */
@FeignClient(name="gateway", configuration = GatewayClientConfig.class)
public interface GatewayClient {
    @RequestMapping("/icndb/api/v1/jokes/{id}")
    Joke getJoke(@RequestParam("id") final Integer id);

    @RequestMapping("/icndb/api/v1/jokes/random")
    Joke getRandomJoke();

    @RequestMapping("/icndb/api/v1/jokes/random/{count}")
    Collection<Joke> getRandomJokes(@RequestParam("count") final Integer count);

    @RequestMapping("/icndb/api/v1/categories")
    Collection<String> getCategories();

    @RequestMapping("/icndb/api/v1/jokes/count")
    Integer getJokeCount();
}
