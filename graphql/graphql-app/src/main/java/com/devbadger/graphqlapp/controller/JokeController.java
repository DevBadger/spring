package com.devbadger.graphqlapp.controller;


import com.devbadger.graphqlapp.service.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/jokes")
public class JokeController {

    private final GraphQLService graphQLService;

    @Autowired
    public JokeController(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @PostMapping
    public ResponseEntity<Object> getAllJokes(@RequestBody String query){
        return ResponseEntity.ok(graphQLService.getGraphQL().execute(query));
    }

}

