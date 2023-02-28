package com.poc.graphqlserver.repository;

import com.poc.graphqlserver.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
