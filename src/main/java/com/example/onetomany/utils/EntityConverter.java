package com.example.onetomany.utils;

import com.example.onetomany.dto.AccountResponse;
import com.example.onetomany.dto.AddressResponse;
import com.example.onetomany.dto.CustomerResponse;
import com.example.onetomany.entity.Account;
import com.example.onetomany.entity.Address;
import com.example.onetomany.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {
    public static AddressResponse addressConverter(Address address){

        return  new AddressResponse(address.getId(),address.getCity(),address.getStreet());
    }
    public static List<AddressResponse> addressListConverter(List<Address> addressList){
  List<AddressResponse> addressResponseList = new ArrayList<>();
  for(Address address : addressList){

      addressResponseList.add(new AddressResponse(address.getId(),address.getCity(),address.getStreet()));
  }
  return addressResponseList ;

    }
    public static CustomerResponse customerConverter(Customer customer){

        return  new CustomerResponse(customer.getId(),customer.getFirstName(),customer.getLastName());
    }
    public static List<CustomerResponse> customerListConverter(List<Customer> customerList){
        List<CustomerResponse> CustomerResponseList = new ArrayList<>();
        for(Customer customer : customerList){

            CustomerResponseList.add(new CustomerResponse(customer.getId(),customer.getFirstName(),customer.getLastName()));
        }
        return CustomerResponseList ;

    }
    public static AccountResponse accountConverter(Account account){

        return  new AccountResponse(account.getId(),account.getAccountName(),account.getMoneyAmount(),customerConverter(account.getCustomer()));
    }
    public static List<AccountResponse> accountListConverter(List<Account> accountList){
        List<AccountResponse> AccountResponseList = new ArrayList<>();
        for(Account account : accountList){

            AccountResponseList.add(new AccountResponse(account.getId(),account.getAccountName(),account.getMoneyAmount(),customerConverter(account.getCustomer())));
        }
        return AccountResponseList ;

    }
}
