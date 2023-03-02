package com.poc.graphqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface PaperRepository extends JpaRepository<Paper, String>, QuerydslPredicateExecutor<Paper> {
}
