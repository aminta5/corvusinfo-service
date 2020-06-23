package com.corvusinfo.registrationapi.repositories;

import com.corvusinfo.registrationapi.model.Account;
import com.corvusinfo.registrationapi.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, String> {
    Optional<VerificationToken> findByAccount(Account account);
    Optional<VerificationToken> findByToken(String token);
}
