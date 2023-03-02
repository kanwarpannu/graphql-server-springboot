package com.poc.graphqlserver.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Paper {

    @Id
    private String id;
    private String name;

}