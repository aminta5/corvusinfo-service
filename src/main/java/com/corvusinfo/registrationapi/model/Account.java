package com.corvusinfo.registrationapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    @Column
    private String accountId;

    @Column
    private String password;

    public Account(String accountId){
        this.accountId = accountId;
    }
}
