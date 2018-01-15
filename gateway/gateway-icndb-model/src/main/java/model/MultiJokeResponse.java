package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.pojomatic.annotations.AutoProperty;

import java.util.Collection;

/**
 * Created by Badger on 1/15/18.
 */
@AutoProperty
@JsonDeserialize(builder = MultiJokeResponse.Builder.class)
public class MultiJokeResponse {
    public MultiJokeResponse(final Builder builder) {
        this.type = builder.getType();
        this.value = builder.getValue();
    }

    public String getType() {
        return type;
    }

    public Collection<Joke> getValue() {
        return value;
    }

    private final String type;
    private final Collection<Joke> value;

    public static class Builder {
        public MultiJokeResponse build() {
            return new MultiJokeResponse(this);
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Collection<Joke> getValue() {
            return value;
        }

        public void setValue(Collection<Joke> value) {
            this.value = value;
        }

        private String type;
        private Collection<Joke> value;
    }
}
