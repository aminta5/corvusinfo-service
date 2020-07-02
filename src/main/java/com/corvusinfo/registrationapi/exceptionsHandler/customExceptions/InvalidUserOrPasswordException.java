package com.corvusinfo.registrationapi.exceptionsHandler.customExceptions;

public class InvalidUserOrPasswordException extends RuntimeException{
    public InvalidUserOrPasswordException(String message){
        super(message);
    }
}
