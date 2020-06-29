package com.corvusinfo.registrationapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegistrationRequest {
    @NotNull
    private String registration;
    private String date;
}
