package com.corvusinfo.registrationapi.repositories;

import com.corvusinfo.registrationapi.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
