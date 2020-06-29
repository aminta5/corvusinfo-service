package com.corvusinfo.registrationapi.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String accountId;

    @Column
    private String password;

    @Column
    private int registrationCounter;

    public Account(String accountId){
        this.accountId = accountId;
    }
}
