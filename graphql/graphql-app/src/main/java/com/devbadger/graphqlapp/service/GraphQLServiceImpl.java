package com.devbadger.graphqlapp.service;

import com.devbadger.graphqlapp.datafetcher.AllJokesDataFetcher;
import com.devbadger.graphqlapp.datafetcher.JokeByIdDataFetcher;
import com.devbadger.graphqlapp.datafetcher.RandomJokeDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLServiceImpl implements GraphQLService{
    @Value("classpath:joke.graphql") Resource resource;
    private AllJokesDataFetcher allJokesDataFetcher;
    private JokeByIdDataFetcher jokeByIdDataFetcher;
    private RandomJokeDataFetcher randomJokeDataFetcher;
    private GraphQL graphQL;

    @Autowired
    public GraphQLServiceImpl(AllJokesDataFetcher allJokesDataFetcher, JokeByIdDataFetcher jokeByIdDataFetcher, RandomJokeDataFetcher randomJokeDataFetcher) {
        this.allJokesDataFetcher = allJokesDataFetcher;
        this.jokeByIdDataFetcher = jokeByIdDataFetcher;
        this.randomJokeDataFetcher = randomJokeDataFetcher;
    }

    //load schema at application start up
    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring(){
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allJokes", allJokesDataFetcher)
                        .dataFetcher("jokeById", jokeByIdDataFetcher)
                        .dataFetcher("randomJoke", randomJokeDataFetcher)
                )
                .build();
    }

    public GraphQL getGraphQL() { return graphQL; }
}
