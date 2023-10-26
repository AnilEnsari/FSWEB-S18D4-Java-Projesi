package com.example.onetomany.service;

import com.example.onetomany.dao.AddressRepository;
import com.example.onetomany.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.spi.CalendarDataProvider;

@Service
public class AdressImpl implements AddressService{
    AddressRepository addressRepository;
@Autowired
    public AdressImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findById(int id) {
       Optional <Address> address = addressRepository.findById(id);
       if(address.isPresent()){
           return address.get();

       }

           return null;

    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address put(Address address, int id) {
    List <Address> addressList = findAll();
    for (Address address1 : addressList){
        if (address1.getId()== id){
            address1=address;
        }
    }
    return address;
    }

    @Override
    public Address delete(int id) {
        Address deletedAddress = findById(id);
        addressRepository.delete(deletedAddress);
        return deletedAddress;
    }
}
