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

//    def joke1 = new Joke.Builder()
//            .setId(1)
//            .setJoke("Chuck Norris uses ribbed condoms inside out, so he gets the pleasure.")
//            .setCategories(["explicit"] as Collection<String>)
//            .build()
//
//    def joke2 = new Joke.Builder()
//            .setId(2)
//            .setJoke("MacGyver can build an airplane out of gum and paper clips. Chuck Norris can kill him and take it.")
//            .setCategories([] as Collection<String>)
//            .build()

    def setup(){
//        icndbService.getJoke(1) >> Optional.of(joke1)
//        icndbService.getRandomJokes(2) >> Optional.of([joke1,joke2] as Collection<Joke>)
        icndbService.jokeCategories >> ["explicit","nerdy"]
        icndbService.jokeCount >> (558 as Integer)

        RestAssuredMockMvc.standaloneSetup(icndbController)
    }
}
