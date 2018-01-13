package icndb.client

import model.JokeResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
/**
 * Created by Badger on 1/12/18.
 */
@FeignClient(url="${icndb.api.url}", name="api.icndb", configuration=IcndbFeignClientConfig.class)
interface IcndbFeignClient {
    /**
     * Returns joke
     *
     * @param firstName is replacement for Chuck in the Chuck Norris joke.
     * @param lastName is replacement for Norris in the Chuck Norris joke.
     * @param limit tells how many jokes to return
     * @return
     */

    @GetMapping(value="/categories")
    Collection<String> getJokeCategories()

    @GetMapping(value="/jokes/count")
    int getJokeCount()

    @GetMapping(value="/jokes/{id}")
    JokeResponse getJoke( @RequestParam("id") final int id )


    @GetMapping(value="/jokes/random/")
    JokeResponse getRandomJoke()

    @GetMapping(value="/random/{limit}")
    JokeResponse getRandomJokeByCategory(
            @PathVariable("limit") final int limit,
            @RequestParam("limitTo") final Collection<String> limitTo,
            @RequestParam("firstName") final String firstName,
            @RequestParam("lastName") final String lastName
    )

    @GetMapping(value="/random/{limit}")
    JokeResponse getRandomJokeExcludeCategory(
            @PathVariable("limit") final int limit,
            @RequestParam("exclude") final Collection<String> exclude,
            @RequestParam("firstName") final String firstName,
            @RequestParam("lastName") final String lastName
    )
}
