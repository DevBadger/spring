package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

/**
 * Created by Badger on 1/12/18.
 */
public class GatewayIcndbObjectMapper extends ObjectMapper {
    public GatewayIcndbObjectMapper() {
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        registerModule(new GuavaModule());
        registerModule(new Jdk8Module());
        setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        registerSubtypes(new NamedType(GenericResponse.class, "jokes"));
        registerSubtypes(new NamedType(SingleJokeResponse.class, "jokes"));
        registerSubtypes(new NamedType(MultiJokeResponse.class, "jokes"));
    }
}
