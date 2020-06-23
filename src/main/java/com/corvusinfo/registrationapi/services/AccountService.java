package com.corvusinfo.registrationapi.services;

import com.corvusinfo.registrationapi.dto.AccountResponse;
import com.corvusinfo.registrationapi.model.Account;
import com.corvusinfo.registrationapi.repositories.AccountRepository;
import com.corvusinfo.registrationapi.util.Helper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public  Account saveAccount(Account id){
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        Optional<Account> acc = accounts.stream().filter(a -> a.getAccountId().equals(id.getAccountId())).findFirst();
        if(!acc.isPresent()){
            id.setPassword(Helper.generatePassword());
            return accountRepository.save(id);
        }
        return new Account();

    }

    public Account findAccountWithId(String id){
        return accountRepository.findAccountById(id).orElseThrow(() -> new RuntimeException("Account with this id not found"));
    }
}
