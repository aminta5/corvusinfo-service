package com.corvusinfo.registrationapi.services;

import com.corvusinfo.registrationapi.model.Account;
import com.corvusinfo.registrationapi.repositories.AccountRepository;
import com.corvusinfo.registrationapi.util.Helper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private  final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public  Account saveAccount(String id){
        Account acc = new Account();
        acc.setAccountId(id);
        acc.setPassword(Helper.generatePassword());
        return accountRepository.save(acc);
    }
}
