package com.poc.graphqlserver.controller;

import com.poc.graphqlserver.entity.Author;
import com.poc.graphqlserver.entity.Book;
import com.poc.graphqlserver.entity.BookInput;
import com.poc.graphqlserver.repository.AuthorRepository;
import com.poc.graphqlserver.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }

    @MutationMapping
    Book addBook(@Argument BookInput book) {
        Author author = authorRepository.findById(book.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("Unknown Author"));
        Book book1 = new Book(book.getTitle(), book.getPublisher(), author);
        return bookRepository.save(book1);
    }

}
