package icndb.service

import icndb.client.IcndbFeignClient
import org.springframework.context.annotation.Bean

/**
 * Created by Badger on 1/13/18.
 */
class IcndbServiceConfig {

    @Bean
    IcndbService icndbService(final IcndbFeignClient icndbFeignClient) {
        new IcndbServiceImpl(icndbFeignClient)
    }
}
