package com.example.onetomany.controller;

import com.example.onetomany.dto.AddressResponse;
import com.example.onetomany.service.AddressService;
import com.example.onetomany.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AdressController {
    private AddressService addressService;

    @Autowired
    public AdressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable int id ){
       return EntityConverter.addressConverter(addressService.findById(id)) ;
    }

}
