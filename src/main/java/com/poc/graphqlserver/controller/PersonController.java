package com.poc.graphqlserver.controller;

import com.poc.graphqlserver.entity.Address;
import com.poc.graphqlserver.entity.Person;
import com.poc.graphqlserver.repository.AddressRepository;
import com.poc.graphqlserver.repository.PersonRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public PersonController(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @QueryMapping(value = "persons")
    public List<Person> getAllPersons() {
        System.out.println("Querying all Persons");
        return personRepository.findAll();
    }

    @QueryMapping(value = "personById")
    public Optional<Person> getPerson(@Argument(name = "id") Integer id) {
        System.out.println("Querying Person");
        return personRepository.findById(id);
    }

    @SchemaMapping(value = "address")
    public List<Address> getAddress(Person person) {
        System.out.println("Fetching address");
        return addressRepository.findByPersonId(person.getId());
    }

    @SchemaMapping(value = "phone")
    public String getPhone(Person person) {
        System.out.println("Fetching phone");
        throw new RuntimeException("Did not find phone data");
    }

    @MutationMapping(name = "createPerson")
    public Person addPerson(@Argument(name = "person") Person person) {
        return personRepository.save(person);
    }

    @MutationMapping(name = "createAddress")
    public Address addAddress(@Argument(name = "address") Address address) {
        return addressRepository.save(address);
    }
}

