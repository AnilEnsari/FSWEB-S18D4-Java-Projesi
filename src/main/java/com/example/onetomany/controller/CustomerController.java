package com.example.onetomany.controller;
import com.example.onetomany.dto.CustomerResponse;
import com.example.onetomany.entity.Customer;
import com.example.onetomany.service.CustomerService;
import com.example.onetomany.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable int id ){
        return EntityConverter.customerConverter(customerService.findById(id)) ;
    }
    @GetMapping("/")
    public List<CustomerResponse> findAll (){
        return EntityConverter.customerListConverter(customerService.findAll());
    }
    @PostMapping("/{id}")
    public CustomerResponse save (@RequestBody Customer customer){

        return EntityConverter.customerConverter(customerService.save(customer));
    }
    @DeleteMapping("/{id}")
    public CustomerResponse delete (@PathVariable int id){
        return EntityConverter.customerConverter(customerService.delete(id));
    }
    @PutMapping("/{id}")
    public CustomerResponse update (@PathVariable int id,@RequestBody Customer customer){
        return EntityConverter.customerConverter(customerService.put(customer,id));

    }
}
