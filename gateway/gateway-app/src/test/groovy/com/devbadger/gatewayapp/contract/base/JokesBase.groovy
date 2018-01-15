package com.devbadger.gatewayapp.contract.base

import com.devbadger.gatewayapp.rest.IcndbController
import com.devbadger.icndb.service.IcndbService
import spock.lang.Specification

/**
 * Created by Badger on 1/15/18.
 */
class JokesBase extends Specification{
    def icndbService = Mock(IcndbService)
    def icndbController = new IcndbController(icndbService)
    
    def setup(){
        def 
    }
}
