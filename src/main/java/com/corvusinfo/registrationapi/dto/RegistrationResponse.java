package com.corvusinfo.registrationapi.dto;

import lombok.Data;

@Data
public class RegistrationResponse {
    private boolean success;
    private String description;
}
