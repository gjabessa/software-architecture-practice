package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureDataMongo
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepostiory customerRepostiory;

    @Test
    void canary(){
        assertNotNull(customerRepostiory);
    }

    @Test
    void addsCustomer(){
        Address address = new Address();
        int prevSize = customerRepostiory.findAll().size();
        Customer customer = new Customer("test","test",address,"test","test");
        customerRepostiory.insert(customer);
        assertEquals(prevSize+1,customerRepostiory.findAll().size());
    }

}
