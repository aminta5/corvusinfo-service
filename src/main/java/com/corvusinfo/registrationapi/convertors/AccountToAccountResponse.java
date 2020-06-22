package com.corvusinfo.registrationapi.convertors;

import com.corvusinfo.registrationapi.dto.AccountResponse;
import com.corvusinfo.registrationapi.model.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountResponse implements Converter<Account, AccountResponse> {


    @Override
    public AccountResponse convert(Account account) {
        AccountResponse response = new AccountResponse();
        if(account.getPassword() == null){
            response.setSuccess(false);
            response.setDescription("Provided accountID already exists");
            return response;
        }
        response.setSuccess(true);
        response.setDescription("Your account has benn successfully opened");
        response.setPassword(account.getPassword());
        return response;
    }
}
