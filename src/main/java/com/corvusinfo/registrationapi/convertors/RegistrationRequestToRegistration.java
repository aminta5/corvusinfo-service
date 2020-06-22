package com.corvusinfo.registrationapi.convertors;

import com.corvusinfo.registrationapi.dto.RegistrationRequest;
import com.corvusinfo.registrationapi.model.Registration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
public class RegistrationRequestToRegistration implements Converter<RegistrationRequest, Registration> {
    @Override
    public Registration convert(RegistrationRequest registrationRequest) {
        Registration registration = new Registration();
        registration.setRegistration(registrationRequest.getRegistration());
        String[] dateTokens  = registrationRequest.getDate().split("\\.");
        LocalDate date = LocalDate.of(Integer.parseInt(dateTokens[2]), Integer.parseInt(dateTokens[1]), Integer.parseInt(dateTokens[0]));
        registration.setDate(date);
        return registration;
    }
}
