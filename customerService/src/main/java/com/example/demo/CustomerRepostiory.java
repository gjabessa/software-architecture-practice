package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepostiory extends MongoRepository<Customer, String> {

}
