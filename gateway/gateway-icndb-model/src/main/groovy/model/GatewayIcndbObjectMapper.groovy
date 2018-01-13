package model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.jsontype.NamedType
import com.fasterxml.jackson.datatype.guava.GuavaModule
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module

import static com.fasterxml.jackson.annotation.JsonAutoDetect.*
import static com.fasterxml.jackson.annotation.PropertyAccessor.*
import static com.fasterxml.jackson.databind.DeserializationFeature.*

/**
 * Created by Badger on 1/12/18.
 */
class GatewayIcndbObjectMapper extends ObjectMapper{
    GatewayIcndbObjectMapper() {
        serializationInclusion = JsonInclude.Include.NON_NULL
        registerModule(new GuavaModule())
        registerModule(new Jdk8Module())
        setVisibility(ALL, Visibility.NONE)
        setVisibility(FIELD, Visibility.ANY)
        configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
        registerSubtypes(new NamedType(JokeResponse, "jokes"))
    }
}
