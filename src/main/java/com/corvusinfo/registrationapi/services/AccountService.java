package com.corvusinfo.registrationapi.services;

import com.corvusinfo.registrationapi.convertors.AccountToStatisticsResponse;
import com.corvusinfo.registrationapi.dto.StatisticsResponse;
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
    private final AccountToStatisticsResponse converter;

    public AccountService(AccountRepository accountRepository, AccountToStatisticsResponse converter) {
        this.accountRepository = accountRepository;
        this.converter = converter;
    }

    public List<StatisticsResponse> getAllAccounts(){
        List<StatisticsResponse> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(a -> accounts.add(converter.convert(a)));
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
        return accountRepository.findAccountByAccountId(id).orElseThrow(() -> new RuntimeException("Account with this id not found"));
    }
}
