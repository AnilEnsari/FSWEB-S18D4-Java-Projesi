package com.example.onetomany.service;

import com.example.onetomany.entity.Account;

import java.util.List;

public interface AccountService {
     Account findById(int id);
     List<Account> findAll();
     Account save(Account account);
     Account put(Account account,int id);
     Account delete(int id);
}
