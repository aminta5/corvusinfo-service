package com.corvusinfo.registrationapi.controllers;

import com.corvusinfo.registrationapi.convertors.RegistrationRequestToRegistration;
import com.corvusinfo.registrationapi.convertors.RegistrationToRegistrationResponse;
import com.corvusinfo.registrationapi.dto.CheckRegistrationRequest;
import com.corvusinfo.registrationapi.dto.RegistrationRequest;
import com.corvusinfo.registrationapi.dto.RegistrationResponse;
import com.corvusinfo.registrationapi.dto.ValidRegistrationResponse;
import com.corvusinfo.registrationapi.model.Account;
import com.corvusinfo.registrationapi.model.Registration;
import com.corvusinfo.registrationapi.services.AccountService;
import com.corvusinfo.registrationapi.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AccountService accountService;
    private final RegistrationToRegistrationResponse converter;
    private final RegistrationRequestToRegistration converter1;

    public RegistrationController(RegistrationService registrationService, AccountService accountService, RegistrationToRegistrationResponse converter, RegistrationRequestToRegistration converter1) {
        this.registrationService = registrationService;
        this.accountService = accountService;
        this.converter = converter;
        this.converter1 = converter1;
    }

    @GetMapping(path="/registration/registrationCode")
    public ValidRegistrationResponse checkRegNumber(@RequestBody CheckRegistrationRequest request){
        return registrationService.checkRegistration(request.getRegistration());
    }
    @PostMapping(path="/register")
    public ResponseEntity<RegistrationResponse> createRegistration(@Valid @RequestBody RegistrationRequest request, Authentication authentication){
        Account account = accountService.findAccountWithId(authentication.getName());
        accountService.saveAccount(account);
        account.setRegistrationCounter(account.getRegistrationCounter() + 1);
        Registration registration = converter1.convert(request);
        RegistrationResponse response = converter.convert(registrationService.saveRegistration(registration));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
