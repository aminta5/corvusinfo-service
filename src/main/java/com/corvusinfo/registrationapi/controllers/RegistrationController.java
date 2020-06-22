package com.corvusinfo.registrationapi.controllers;

import com.corvusinfo.registrationapi.convertors.RegistrationRequestToRegistration;
import com.corvusinfo.registrationapi.convertors.RegistrationToRegistrationResponse;
import com.corvusinfo.registrationapi.dto.RegistrationRequest;
import com.corvusinfo.registrationapi.dto.RegistrationResponse;
import com.corvusinfo.registrationapi.model.Registration;
import com.corvusinfo.registrationapi.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final RegistrationService registrationService;
    private final RegistrationToRegistrationResponse converter;
    private final RegistrationRequestToRegistration converter1;

    public RegistrationController(RegistrationService registrationService, RegistrationToRegistrationResponse converter, RegistrationRequestToRegistration converter1) {
        this.registrationService = registrationService;
        this.converter = converter;
        this.converter1 = converter1;
    }

    @PostMapping(path="/register")
    public ResponseEntity<RegistrationResponse> createRegistration(@RequestBody RegistrationRequest request){
        Registration registration = converter1.convert(request);
        RegistrationResponse response = converter.convert(registrationService.saveRegistration(registration));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
