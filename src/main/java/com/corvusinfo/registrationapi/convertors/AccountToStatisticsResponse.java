package com.corvusinfo.registrationapi.convertors;

import com.corvusinfo.registrationapi.dto.StatisticsResponse;
import com.corvusinfo.registrationapi.model.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountToStatisticsResponse implements Converter<Account, StatisticsResponse> {
    @Override
    public StatisticsResponse convert(Account account) {
        StatisticsResponse response = new StatisticsResponse();
        response.setAccountId(account.getAccountId());
        response.setRegCounter(account.getRegistrationCounter());
        return response;
    }
}
