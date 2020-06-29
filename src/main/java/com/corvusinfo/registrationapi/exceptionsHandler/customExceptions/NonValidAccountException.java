package com.corvusinfo.registrationapi.exceptionsHandler.customExceptions;

public class NonValidAccountException extends RuntimeException{
    public NonValidAccountException(String message){
        super(message);
    }
}
