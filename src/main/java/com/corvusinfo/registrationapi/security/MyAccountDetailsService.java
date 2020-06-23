package com.corvusinfo.registrationapi.security;

import com.corvusinfo.registrationapi.model.Account;
import com.corvusinfo.registrationapi.services.AccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyAccountDetailsService implements UserDetailsService {
    private final AccountService accountService;

    public MyAccountDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Account account= accountService.findAccountWithId(id);
        if(account == null){
            throw new RuntimeException(id + " not found");
        }
        return new MyAccountDetails(account);
    }
}
