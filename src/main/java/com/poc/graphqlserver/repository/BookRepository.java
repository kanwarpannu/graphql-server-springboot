package com.poc.graphqlserver.repository;

import com.poc.graphqlserver.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
