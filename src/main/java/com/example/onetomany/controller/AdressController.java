package com.example.onetomany.controller;

import com.example.onetomany.dto.AddressResponse;
import com.example.onetomany.entity.Address;
import com.example.onetomany.service.AccountService;
import com.example.onetomany.service.AddressService;
import com.example.onetomany.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/")
    public List<AddressResponse> findAll (){
        return EntityConverter.addressListConverter(addressService.findAll());
    }
    @PostMapping("/")
    public AddressResponse save (@RequestBody Address address){

        return EntityConverter.addressConverter(addressService.save(address));
    }
    @DeleteMapping("/{id}")
    public AddressResponse delete (@PathVariable int id){
        return EntityConverter.addressConverter(addressService.delete(id));
    }
    @PutMapping("/{id}")
    public AddressResponse update (@PathVariable int id,@RequestBody Address address){
       return EntityConverter.addressConverter(addressService.put(address,id));

    }

}
