package com.corvusinfo.registrationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegistrationApiApplication extends SpringBootServletInitializer {

     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RegistrationApiApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApiApplication.class, args);
    }

}
