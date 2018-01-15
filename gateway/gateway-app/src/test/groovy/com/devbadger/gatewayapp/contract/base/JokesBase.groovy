package com.devbadger.gatewayapp.contract.base

import com.devbadger.gatewayapp.rest.IcndbController
import com.devbadger.icndb.service.IcndbService
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import model.GenericResponse
import model.Joke
import model.MultiJokeResponse
import model.SingleJokeResponse
import spock.lang.Specification

/**
 * Created by Badger on 1/15/18.
 */
class JokesBase extends Specification{
    def icndbService = Mock(IcndbService)
    def icndbController = new IcndbController(icndbService)
    
    def setup(){
        def categories = ["explicit","nerdy"]
        def count = 558

        def joke1 = new Joke.Builder()
                .setId(1)
                .setJoke("Chuck Norris uses ribbed condoms inside out, so he gets the pleasure.")
                .setCategories(["explicit"])
                .build()

        def joke2 = new Joke.Builder()
                .setId(2)
                .setJoke("MacGyver can build an airplane out of gum and paper clips. Chuck Norris can kill him and take it.")
                .setCategories([])
                .build()

        def singleJokeResponse = new SingleJokeResponse.Builder()
                .setType("success")
                .setValue(joke1)
                .build()

        def multiJokeResponse = new MultiJokeResponse.Builder()
                .setType("success")
                .setValue([joke1,joke2])
                .build()

        def categoryResponse = new GenericResponse.Builder()
                .setType("success")
                .setValue(categories)
                .build()

        def countResponse = new GenericResponse.Builder()
                .setType("success")
                .setValue(count)
                .build()

        icndbService.getJoke(_ as Integer) >> singleJokeResponse
        icndbService.getRandomJokes(_ as Integer) >> multiJokeResponse
        icndbService.jokeCategories >> categoryResponse
        icndbService.jokeCount >> countResponse

        RestAssuredMockMvc.standaloneSetup(icndbController)
    }
}
