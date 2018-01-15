package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.pojomatic.annotations.AutoProperty;

import java.util.Collection;

/**
 * Created by Badger on 1/15/18.
 */
@AutoProperty
@JsonDeserialize(builder = MultiJokeResponse.Builder.class)
public class MultiJokeResponse extends Model{
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
        private String type;
        private Collection<Joke> value;

        public String getType() {
            return type;
        }
        public Collection<Joke> getValue() {
            return value;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }
        public Builder setValue(Collection<Joke> value) {
            this.value = value;
            return this;
        }

        public MultiJokeResponse build() {
            return new MultiJokeResponse(this);
        }
    }
}
