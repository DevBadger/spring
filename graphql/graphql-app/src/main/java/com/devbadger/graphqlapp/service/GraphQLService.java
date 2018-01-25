package com.devbadger.graphqlapp.service;

import graphql.GraphQL;

import java.io.IOException;

public interface GraphQLService {
    void loadSchema() throws IOException;
    GraphQL getGraphQL();
}
