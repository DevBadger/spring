package com.devbadger.icndb.client;

import model.GenericResponse;
import model.MultiJokeResponse;
import model.SingleJokeResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Badger on 1/12/18.
 */
@FeignClient(url = "${icndb.api.url}", name = "api.icndb", configuration = IcndbFeignClientConfig.class)
public interface IcndbFeignClient {

    /**
     * @param id is the unique identifier of each joke in a joke response
     * @return SingleJokeReponse
     */
    @GetMapping("/jokes/{id}")
    SingleJokeResponse getJoke(
            @RequestParam("id") final int id);

    /**
     * @return SingleJokeResponse
     */
    @GetMapping("/jokes/random")
    SingleJokeResponse getRandomJoke();

    /**
     * @return MultiJokeResponse
     * @param limit tells how many jokes to return
     */
    @GetMapping("/jokes/random/{limit}")
    MultiJokeResponse getRandomJokes(
            @RequestParam("limit") final Integer limit
    );

    /**
     * @return MultiJokeResponse
     */
    @GetMapping("/jokes")
    MultiJokeResponse getAllJokes();

    /**
     * @return available joke categories as Collection of Strings
     */
    @GetMapping("/categories")
    GenericResponse getJokeCategories();

    /**
     * @return number of available jokes
     */
    @GetMapping("/jokes/count")
    GenericResponse getJokeCount();
}
