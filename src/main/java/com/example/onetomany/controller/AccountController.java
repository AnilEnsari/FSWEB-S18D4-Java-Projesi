package com.example.onetomany.controller;


import com.example.onetomany.dto.AccountResponse;
import com.example.onetomany.entity.Account;
import com.example.onetomany.entity.Customer;
import com.example.onetomany.service.AccountService;
import com.example.onetomany.service.CustomerService;
import com.example.onetomany.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }
    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable int id ){
        return EntityConverter.accountConverter(accountService.findById(id)) ;
    }
    @GetMapping("/")
    public List<AccountResponse> findAll (){
        return EntityConverter.accountListConverter(accountService.findAll());
    }
    @PostMapping("/{customerid}")
    public List<AccountResponse>  save (@PathVariable int customerid,@RequestBody Account account){

        Customer customer = customerService.findById(customerid);
        customerService.addAccount(customer,account);
        account.setCustomer(customer);


        return EntityConverter.accountListConverter(customer.getAccountList());
    }
    @DeleteMapping("/{id}")
    public AccountResponse delete (@PathVariable int id){
        return EntityConverter.accountConverter(accountService.delete(id));
    }
    @PutMapping("/{customerid}")
    public AccountResponse update (@PathVariable int customerid,@RequestBody Account account){

        Customer customer = customerService.findById(customerid);
        for(Account account1 : customer.getAccountList()){

            if (account1.getId()==account.getId()){

                account1 = account;
                account1.setCustomer(customer);
                return EntityConverter.accountConverter(account1);
            }

        }

return  null ;
    }
}
