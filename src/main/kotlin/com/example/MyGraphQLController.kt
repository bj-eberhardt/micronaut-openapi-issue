package com.example

import io.micronaut.configuration.graphql.GraphQLController
import io.micronaut.configuration.graphql.GraphQLExecutionResultHandler
import io.micronaut.configuration.graphql.GraphQLInvocation
import io.micronaut.configuration.graphql.GraphQLJsonSerializer
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.swagger.v3.oas.annotations.Hidden
import org.reactivestreams.Publisher

@Controller("/hello")
@Hidden
@Consumes(MediaType.ALL)
@Produces(MediaType.APPLICATION_JSON)
class MyGraphQLController(
        graphQLInvocation: GraphQLInvocation,
        graphQLExecutionResultHandler: GraphQLExecutionResultHandler,
        graphQLJsonSerializer : GraphQLJsonSerializer
) : GraphQLController(graphQLInvocation, graphQLExecutionResultHandler,  graphQLJsonSerializer) {


    @Get(produces = [MediaType.APPLICATION_JSON])
    override fun get(query: String?, operationName: String?, variables: String?, httpRequest: HttpRequest<*>?): Publisher<String> {
        return super.get(query, operationName, variables, httpRequest)
    }

    @Post(consumes = [MediaType.ALL], produces = [MediaType.APPLICATION_JSON])
    override fun post(query: String?, operationName: String?, variables: String?, body: String?, httpRequest: HttpRequest<*>?): Publisher<String> {
        return super.post(query, operationName, variables, body, httpRequest)
    }
}