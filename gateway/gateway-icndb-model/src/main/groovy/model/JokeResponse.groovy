package model

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.pojomatic.annotations.AutoProperty

/**
 * Created by Badger on 1/12/18.
 */
@AutoProperty
@JsonDeserialize(builder = Builder.class)
class JokeResponse extends Model{
    private final long jokeId
    private final String jokeStr

    JokeResponse(final Builder builder) {
        this.jokeId = builder.jokeId
        this.jokeStr = builder.jokeStr
    }

    static class Builder {
        long jokeId
        String jokeStr

        JokeResponse build(){ new JokeResponse(this) }
    }
}

