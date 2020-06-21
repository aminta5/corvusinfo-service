package com.corvusinfo.registrationapi.services;

import com.corvusinfo.registrationapi.model.Registration;
import com.corvusinfo.registrationapi.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Registration save(Registration registration){
        return regRepo.save(registration);
    }
}
