package com.poc.graphqlserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    private Integer id;
    private Integer personId;

    private String street;
    private AddressType type;


}
