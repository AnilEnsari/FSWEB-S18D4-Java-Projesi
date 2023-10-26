package com.example.onetomany.service;

import com.example.onetomany.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(int id);
    List<Customer> findAll();
    Customer save(Customer customer);
    Customer put(Customer customer,int id);
    Customer delete(int id);
}
