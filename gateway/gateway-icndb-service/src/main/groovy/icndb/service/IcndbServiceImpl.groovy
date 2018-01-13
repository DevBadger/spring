package icndb.service

import icndb.client.IcndbFeignClient
import model.Joke
import model.JokeResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.lang.invoke.MethodHandles

/**
 * Created by Badger on 1/13/18.
 */
class IcndbServiceImpl implements IcndbService{
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    private final IcndbFeignClient icndbFeignClient

    IcndbServiceImpl(IcndbFeignClient icndbFeignClient) {
        this.icndbFeignClient = icndbFeignClient
    }

    @Override
    Optional<Joke> getJoke(Integer id) {
        Objects.requireNonNull(id, "id must not be null")
        JokeResponse response = icndbFeignClient.getJoke(id)
        response.value ? Optional.of(response.value) : Optional.empty()
    }

    @Override
    Integer getJokeCount() { icndbFeignClient.jokeCount }

    @Override
    Collection<String> getJokeCategories() { icndbFeignClient.jokeCategories }

    @Override
    Optional<Joke> getRandomJoke() {
        def response = icndbFeignClient.randomJoke
        response.value.first() ? Optional.of(response.value.first()) : Optional.empty()
    }

    @Override
    Optional<Joke> getRandomJokeByCategory(Collection<String> categories) {
        def response = icndbFeignClient.getRandomJokeByCategory(1, categories, null, null)
        response.value.first() ? Optional.of(response.value.first()) : Optional.empty()
    }

    @Override
    Optional<Joke> getRandomJokeExclude(Collection<String> categories) {
        def response = icndbFeignClient.getRandomJokeExcludeCategory(1, categories, null, null)
        response.value.first() ? Optional.of(response.value.first()) : Optional.empty()
    }

    @Override
    Collection<Joke> getRandomJokes(int count) {
        icndbFeignClient.getRandomJokeByCategory(count, null, null, null).value
    }

    @Override
    Collection<Joke> getRandomJokes(Collection<String> categories, int count, String firstName, String lastName) {
        icndbFeignClient.getRandomJokeByCategory(count, categories, firstName, lastName).value
    }

    @Override
    Collection<Joke> getRandomJokesExclude(Collection<String> categories, int count, String firstName, String lastName) {
        icndbFeignClient.getRandomJokeExcludeCategory(count, categories, firstName, lastName).value
    }
}
