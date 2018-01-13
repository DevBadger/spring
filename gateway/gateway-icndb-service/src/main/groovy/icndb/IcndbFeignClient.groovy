package icndb

import model.JokeResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
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
     * @return
     */
    @GetMapping(value="/random")
    JokeResponse getRandomJoke(
            @RequestParam("firstName") final String firstName,
            @RequestParam("lastName") final String lastName
    )
}
