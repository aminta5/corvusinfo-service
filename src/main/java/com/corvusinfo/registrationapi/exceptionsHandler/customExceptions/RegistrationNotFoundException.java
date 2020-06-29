package com.corvusinfo.registrationapi.exceptionsHandler.customExceptions;

public class RegistrationNotFoundException extends RuntimeException {
    //private String registration;

    public RegistrationNotFoundException(String registration){
        super("No record for this registration number " + registration);
       // this.registration = registration;
    }
}
