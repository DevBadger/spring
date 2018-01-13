package model

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.pojomatic.annotations.AutoProperty

/**
 * Created by Badger on 1/12/18.
 */
@AutoProperty
@JsonDeserialize(builder = Builder.class)
class JokeResponse extends Model{
    private final String type
    private final Collection<Joke> value

    JokeResponse(final Builder builder) {
        this.type = builder.type
        this.value = builder.value
    }

    String getType() {
        return type
    }

    Collection<Joke> getValue() {
        return value
    }

    static class Builder {
        String type
        Collection<Joke> value

        JokeResponse build(){ new JokeResponse(this) }
    }
}

