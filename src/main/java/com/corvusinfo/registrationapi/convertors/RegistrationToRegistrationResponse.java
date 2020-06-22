package com.corvusinfo.registrationapi.convertors;

import com.corvusinfo.registrationapi.dto.RegistrationResponse;
import com.corvusinfo.registrationapi.model.Registration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RegistrationToRegistrationResponse implements Converter<Registration, RegistrationResponse> {
    @Override
    public RegistrationResponse convert(Registration registration) {
        RegistrationResponse response = new RegistrationResponse();
        if(registration.getRegistration() == null){
            response.setSuccess(false);
            response.setDescription("Provided registration code already exists");
            return response;
        }
        response.setSuccess(true);
        response.setDescription("Vehicle registrations is successfully added");
        return response;
    }
}
