package com.poc.graphqlserver;

import com.poc.graphqlserver.entity.Author;
import com.poc.graphqlserver.entity.Book;
import com.poc.graphqlserver.repository.AuthorRepository;
import com.poc.graphqlserver.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlserverApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            Author josh = authorRepository.save(new Author(null, "Josh Long"));
            Author mark = authorRepository.save(new Author(null, "Mark John"));
            bookRepository.saveAll(List.of(
                    new Book("Reactive Java", "Good Books", josh),
                    new Book( "Simple Java", "Good Reads", josh),
                    new Book( "Native Java", "Book Publishing Co", mark)
            ));
        };
    }

}
