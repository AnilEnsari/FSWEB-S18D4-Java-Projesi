package com.example.onetomany.service;


import com.example.onetomany.dao.CustomerRepository;
import com.example.onetomany.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerImpl implements CustomerService{
    CustomerRepository customerRepository;

    @Autowired
    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();

        }

        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer put(Customer customer, int id) {
        List <Customer> customerList = findAll();
        for (Customer customer1 : customerList){
            if (customer1.getId()== id){
                customer1=customer;
            }
        }
        return customer;
    }

    @Override
    public Customer delete(int id) {
        Customer deletedCustomer = findById(id);
        customerRepository.delete(deletedCustomer);
        return deletedCustomer;
    }
}
