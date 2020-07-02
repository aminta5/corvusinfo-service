package com.corvusinfo.registrationapi.controllers;

import com.corvusinfo.registrationapi.exceptionsHandler.customExceptions.InvalidUserOrPasswordException;
import com.corvusinfo.registrationapi.model.AuthRequest;
import com.corvusinfo.registrationapi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getAccountId(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new InvalidUserOrPasswordException("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getAccountId());
    }
}
