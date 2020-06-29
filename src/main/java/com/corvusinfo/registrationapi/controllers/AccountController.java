package com.corvusinfo.registrationapi.controllers;

import com.corvusinfo.registrationapi.convertors.AccountToAccountResponse;
import com.corvusinfo.registrationapi.dto.AccountResponse;
import com.corvusinfo.registrationapi.exceptionsHandler.customExceptions.NonValidAccountException;
import com.corvusinfo.registrationapi.model.Account;
import com.corvusinfo.registrationapi.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {
    private final AccountService accountService;
    private final AccountToAccountResponse converter;

    public AccountController(AccountService accountService, AccountToAccountResponse converter) {
        this.accountService = accountService;
        this.converter = converter;
    }

    @GetMapping(path="/statistics/accountID")
    public Map<String, Integer> getAllAccounts(){
        Map<String, Integer> map = new HashMap<>();
        accountService.getAllAccounts().forEach(a -> map.put(a.getAccountId(), a.getRegCounter()));
        return map;
    }

    @PostMapping(path="/account")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody Account id){
        AccountResponse response = converter.convert(accountService.saveAccount(id));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
