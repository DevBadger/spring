package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.pojomatic.annotations.AutoProperty;

/**
 * Created by Badger on 1/15/18.
 */
@AutoProperty
@JsonDeserialize(builder = GenericResponse.Builder.class)
public class GenericResponse {
    public GenericResponse(final GenericResponse.Builder builder) {
        this.type = builder.getType();
        this.value = builder.getValue();
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    private final String type;
    private final Object value;

    public static class Builder {
        private String type;
        private Object value;

        public String getType() { return type; }
        public Object getValue() { return value; }

        public Builder setValue(Object value) {
            this.value = value;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public GenericResponse build() { return new GenericResponse(this); }
    }
}
