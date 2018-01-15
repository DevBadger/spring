package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.pojomatic.annotations.AutoProperty;

/**
 * Created by Badger on 1/12/18.
 */
@AutoProperty
@JsonDeserialize(builder = SingleJokeResponse.Builder.class)
public class SingleJokeResponse extends Model {
    public SingleJokeResponse(final Builder builder) {
        this.type = builder.getType();
        this.value = builder.getValue();
    }

    public String getType() {
        return type;
    }

    public Joke getValue() {
        return value;
    }

    private final String type;
    private final Joke value;

    public static class Builder {
        public SingleJokeResponse build() {
            return new SingleJokeResponse(this);
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Joke getValue() {
            return value;
        }

        public void setValue(Joke value) {
            this.value = value;
        }

        private String type;
        private Joke value;
    }
}
