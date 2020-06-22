package com.corvusinfo.registrationapi.services;

import com.corvusinfo.registrationapi.model.Registration;
import com.corvusinfo.registrationapi.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private  final RegistrationRepository regRepo;

    public RegistrationService(RegistrationRepository repo) {
        this.regRepo = repo;
    }

    public List<Registration> getAllRegistrations(){
        List<Registration> regs = new ArrayList<>();
        regRepo.findAll().forEach(regs::add);
        return regs;
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
