package icndb;

import feign.Logger
import feign.codec.Decoder
import model.GatewayIcndbObjectMapper
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder
import org.springframework.cloud.netflix.feign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

/**
 * Created by Badger on 1/12/18.
 */
class IcndbFeignClientConfig {

    @Bean
    Logger.Level feignLoggerLevel() { Logger.Level.FULL }

    @Bean
    Decoder feignDecoder() {
        def jacksonConverter = new MappingJackson2HttpMessageConverter(new GatewayIcndbObjectMapper())
        def objectFactory = { -> new HttpMessageConverters(jacksonConverter) }

        new ResponseEntityDecoder(new SpringDecoder(objectFactory))
    }
}