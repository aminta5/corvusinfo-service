package com.corvusinfo.registrationapi.testData;

import com.corvusinfo.registrationapi.model.Registration;
import com.corvusinfo.registrationapi.repositories.RegistrationRepository;
import com.corvusinfo.registrationapi.services.AccountService;
import com.corvusinfo.registrationapi.services.RegistrationService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final RegistrationRepository registrationRepository;
    private final AccountService accountService;

    public DataLoader(RegistrationRepository registrationRepository, AccountService accountService) {
        this.registrationRepository = registrationRepository;
        this.accountService = accountService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        accountService.saveAccount("filip@corvus.com");
        accountService.saveAccount("general@test.com");
        accountService.saveAccount("travel@voyage.com");
        registrationRepository.saveAll(getRegistrations());
    }


    private List<Registration> getRegistrations(){
        List<Registration> registrations = new ArrayList<>();
        Registration reg1 = new Registration("sk692ru", LocalDate.now());
        Registration reg2 = new Registration("oh234ty", LocalDate.now());
        Registration reg3 = new Registration("ge579fi", LocalDate.now());
        registrations.add(reg1);
        registrations.add(reg2);
        registrations.add(reg3);
        return registrations;
    }

}
