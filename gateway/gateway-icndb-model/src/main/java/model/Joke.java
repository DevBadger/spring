package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.pojomatic.annotations.AutoProperty;

import java.util.Collection;

/**
 * Created by Badger on 1/13/18.
 */
@AutoProperty
@JsonDeserialize(builder = Joke.Builder.class)
public class Joke extends Model {
    Joke(final Builder builder) {
        this.id = builder.getId();
        this.joke = builder.getJoke();
        this.categories = builder.getCategories();
    }

    public Integer getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    private final Integer id;
    private final String joke;
    private final Collection<String> categories;

    public static class Builder {
        private Integer id;
        private String joke;
        private Collection<String> categories;

        Integer getId() {
            return id;
        }
        String getJoke() { return joke; }
        Collection<String> getCategories() { return categories; }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setJoke(String joke) {
            this.joke = joke;
            return this;
        }

        public Builder setCategories(Collection<String> categories) {
            this.categories = categories;
            return this;
        }

        public Joke build() {
            return new Joke(this);
        }
    }
}
