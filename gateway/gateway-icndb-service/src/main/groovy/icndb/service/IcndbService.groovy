package icndb.service

import model.Joke

/**
 * Created by Badger on 1/13/18.
 */
interface IcndbService {
    Optional<Joke> getJoke(Integer id)
    Integer getJokeCount()
    Collection<String> getJokeCategories()

    Optional<Joke> getRandomJoke()
    Optional<Joke> getRandomJokeByCategory(Collection<String> categories)
    Optional<Joke> getRandomJokeExclude(Collection<String> categories)

    Collection<Joke> getRandomJokes(int count)
    Collection<Joke> getRandomJokes(Collection<String> categories, int count, String firstName, String lastName)
    Collection<Joke> getRandomJokesExclude(Collection<String> categories, int count, String firstName, String lastName)
}