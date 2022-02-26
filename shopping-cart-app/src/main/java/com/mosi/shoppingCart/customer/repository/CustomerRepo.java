package com.mosi.shoppingCart.customer.repository;

import com.mosi.shoppingCart.customer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {
    Optional<Customer> findByUsernameAndAndPassword(String username, String password);
}

