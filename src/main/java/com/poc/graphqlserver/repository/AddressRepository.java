package com.poc.graphqlserver.repository;

import com.poc.graphqlserver.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByPersonId(Integer personId);
}
