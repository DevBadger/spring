package model

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.pojomatic.annotations.AutoProperty

/**
 * Created by Badger on 1/13/18.
 */
@AutoProperty
@JsonDeserialize(builder = Builder.class)
class Joke extends Model{
    private final long id
    private final String joke
    private final Collection<String> categories

    Joke(final Builder builder) {
        this.id = builder.id
        this.joke = builder.joke
        this.categories = builder.categories
    }

    long getId() {
        return id
    }

    String getJoke() {
        return joke
    }

    Collection<String> getCategories() {
        return categories
    }

    static class Builder {
        long id
        String joke
        Collection<String> categories

        Joke build(){ new Joke(this) }
    }
}
