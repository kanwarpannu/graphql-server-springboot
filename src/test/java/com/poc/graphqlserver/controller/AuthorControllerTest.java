package com.poc.graphqlserver.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
class AuthorControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    private String title;
    private String publisher;

    @BeforeEach
    void setup() {
        title = "test-title";
        publisher = "test-publisher";
    }

    @Test
    void shouldCallAddBookMutation() {
        this.graphQlTester.documentName("author-mutation-schema")
                .variable("title", title)
                .variable("publisher", publisher)
                .execute()
                .path("addBook.title")
                .entity(String.class).isEqualTo(title)
                .path("addBook.publisher")
                .entity(String.class).isEqualTo(publisher);
    }

    @Test
    void shouldAddCallGetAuthorById() {
        this.graphQlTester.documentName("author-query-schema")
                .variable("id", 2)
                .execute()
                .path("authorById.id")
                .entity(Long.class).isEqualTo(2L)
                .path("authorById.name")
                .entity(String.class).isEqualTo("Mark John");
    }
}