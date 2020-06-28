package com.corvusinfo.registrationapi.model;


import com.sun.istack.NotNull;
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
    @NotNull
    private String accountId;

    @Column
    private String password;

    @Column
    private int registrationCounter;

    public Account(String accountId){
        this.accountId = accountId;
    }
}
