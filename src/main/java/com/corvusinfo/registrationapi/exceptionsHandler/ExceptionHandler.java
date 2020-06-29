package com.corvusinfo.registrationapi.exceptionsHandler;

import com.corvusinfo.registrationapi.exceptionsHandler.customExceptions.NonValidAccountException;
import com.corvusinfo.registrationapi.exceptionsHandler.customExceptions.RegistrationNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(RegistrationNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleRegistrationNotFound(RegistrationNotFoundException e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /*@org.springframework.web.bind.annotation.ExceptionHandler(ExpiredJwtException.class)
    public final ResponseEntity<ExceptionResponse> handleExpiredToken(ExpiredJwtException e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse("not authorized for this request", request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }*/

   /* @org.springframework.web.bind.annotation.ExceptionHandler(ExpiredJwtException.class)
    protected ResponseEntity<Object> handleConflict(ExpiredJwtException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }*/

   /* @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleExpception(Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }*/

    @org.springframework.web.bind.annotation.ExceptionHandler(JpaSystemException.class)
    public final ResponseEntity<ExceptionResponse> handleJpaSystemException(JpaSystemException e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ExceptionResponse> handleJpaSystemException(ConstraintViolationException e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse("object already exists", request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

   /* @org.springframework.web.bind.annotation.ExceptionHandler(NonValidAccountException.class)
    public final ResponseEntity<ExceptionResponse> handleAccountNotValidException(NonValidAccountException e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }*/


}
