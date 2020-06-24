package com.corvusinfo.registrationapi.convertors;

import com.corvusinfo.registrationapi.dto.ValidRegistrationResponse;
import com.corvusinfo.registrationapi.model.Registration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RegistrationToValidRegistrationResponse implements Converter<Registration, ValidRegistrationResponse> {
    @Override
    public ValidRegistrationResponse convert(Registration registration) {
        ValidRegistrationResponse response = new ValidRegistrationResponse();
        response.setDate(registration.getDate());
        if(registration.getDate().isAfter(LocalDate.now()) || registration.getDate().equals(LocalDate.now())){
            response.setMesssage("Your registration is still valid");
        }
        else{
            response.setMesssage("Your registration has expired");
        }
        return response;
    }
}
