package com.poc.graphqlserver.repository;

import com.poc.graphqlserver.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}