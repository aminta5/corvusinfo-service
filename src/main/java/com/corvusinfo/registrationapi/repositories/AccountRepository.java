package com.corvusinfo.registrationapi.repositories;

import com.corvusinfo.registrationapi.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, String> {
    Optional<Account> findAccountByAccountId(String id);
}
