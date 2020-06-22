package com.corvusinfo.registrationapi.dto;

import lombok.Data;

@Data
public class AccountResponse {
    private boolean success;
    private String description;
    private String password;
}
