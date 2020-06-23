package com.corvusinfo.registrationapi.services;

import com.corvusinfo.registrationapi.model.Account;
import com.corvusinfo.registrationapi.model.VerificationToken;
import com.corvusinfo.registrationapi.repositories.VerificationTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenService {
    private final VerificationTokenRepository repository;

    public VerificationTokenService(VerificationTokenRepository repository) {
        this.repository = repository;
    }

    public VerificationToken getTokenByAccount(Account account){
        return repository.findByAccount(account).orElseThrow(() -> new RuntimeException("Token not found"));
    }

    public VerificationToken saveToken(VerificationToken token){
        return repository.save(token);
    }

    public VerificationToken createVerificationToken(Account account, String token){
        VerificationToken newAccountToken = new VerificationToken(token, account);
        return repository.save(newAccountToken);
    }

    public VerificationToken getVerificationToken(String verificationToken){
        return repository.findByToken(verificationToken).orElseThrow(() -> new RuntimeException("Token not found"));
    }
}
