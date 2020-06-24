package com.corvusinfo.registrationapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ValidRegistrationResponse {
    private LocalDate date;
    private String messsage;
}
