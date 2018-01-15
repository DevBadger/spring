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
        public GenericResponse build() {
            return new GenericResponse(this);
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        private String type;
        private Object value;
    }
}
