package com.example.onetomany.service;


import com.example.onetomany.entity.Address;

import java.util.List;

public interface AddressService {
    Address findById(int id);
    List<Address> findAll();
    Address save(Address address);
    Address put(Address address,int id);
    Address delete(int id);
}
