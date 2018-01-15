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
    public Joke(final Builder builder) {
        this.id = builder.getId();
        this.joke = builder.getJoke();
        this.categories = builder.getCategories();
    }

    public long getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    private final long id;
    private final String joke;
    private final Collection<String> categories;

    public static class Builder {
        public Joke build() {
            return new Joke(this);
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public Collection<String> getCategories() {
            return categories;
        }

        public void setCategories(Collection<String> categories) {
            this.categories = categories;
        }

        private long id;
        private String joke;
        private Collection<String> categories;
    }
}
