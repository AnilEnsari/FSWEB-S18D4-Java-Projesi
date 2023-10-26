package com.example.onetomany.service;

import com.example.onetomany.dao.AccountRepository;
import com.example.onetomany.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountImpl implements AccountService{
    AccountRepository accountRepository;
@Autowired
    public AccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findById(int id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();

        }

        return null;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account put(Account account, int id) {
        List <Account> accountList = findAll();
        for (Account account1 : accountList){
            if (account1.getId()== id){
                account1=account;
            }
        }
        return account;
    }

    @Override
    public Account delete(int id) {
        Account deletedAccount = findById(id);
        accountRepository.delete(deletedAccount);
        return deletedAccount;
    }
}
