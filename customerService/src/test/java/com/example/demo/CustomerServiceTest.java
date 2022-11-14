package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerRepostiory customerRepostiory;

    @Autowired
    @InjectMocks
    CustomerService sut;

    @Test
    void canary() {
        assertNotNull(sut);
    }

    @Test
    void addsAuser(){
        Address address = new Address();
        Customer customer = new Customer("username","secondName",address,"phone","email");

        sut.add(customer);

        verify(customerRepostiory,times(1)).insert(customer);

    }

    @Test
    void viewsUsers(){
        List<Customer> customers = sut.view();

        verify(customerRepostiory).findAll();
    }

}
