package com.corvusinfo.registrationapi.services;

import com.corvusinfo.registrationapi.convertors.RegistrationToValidRegistrationResponse;
import com.corvusinfo.registrationapi.dto.ValidRegistrationResponse;
import com.corvusinfo.registrationapi.model.Registration;
import com.corvusinfo.registrationapi.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private  final RegistrationRepository regRepo;
    private final RegistrationToValidRegistrationResponse converter;

    public RegistrationService(RegistrationRepository repo, RegistrationToValidRegistrationResponse converter) {
        this.regRepo = repo;
        this.converter = converter;
    }

    public ValidRegistrationResponse checkRegistration(String regCode){
        List<Registration> regs = new ArrayList<>();
        regRepo.findAll().forEach(regs::add);
        Registration registration = regs.stream().filter(r -> r.getRegistration().equals(regCode)).findFirst().orElseThrow(() -> new RuntimeException("registration number not found"));
        return converter.convert(registration);
    }

    public Registration saveRegistration(Registration registration){
        List<Registration> registrations = new ArrayList<>();
        regRepo.findAll().forEach(registrations::add);
        Optional<Registration> optionalReg = registrations.stream().filter(r -> r.getRegistration().equals(registration.getRegistration())).findFirst();
        if(!optionalReg.isPresent()){
            return regRepo.save(registration);
        }
        return new Registration();
    }
}
