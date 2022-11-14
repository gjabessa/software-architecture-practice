package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepostiory customerRepostiory;

    public void add(Customer customer){
        customerRepostiory.insert(customer);
    }

    public List<Customer> view(){
        return customerRepostiory.findAll();
    }


    public void update(Customer customer){
        customerRepostiory.save(customer);
    }

    public void remove(String phone){
        customerRepostiory.deleteById(phone);
    }

}
