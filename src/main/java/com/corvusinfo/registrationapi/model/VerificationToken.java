package com.corvusinfo.registrationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
public class VerificationToken {
    private static final Duration EXPIRATION = Duration.ofMinutes(5);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String token;

    @OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    //@JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @Column
    private LocalDateTime createdDate;
    @Column
    private LocalDateTime expiryDate;

    public VerificationToken(final String token, final Account account) {
        this.token = token;
        this.account = account;
        this.createdDate = LocalDateTime.now();
        this.expiryDate = calculateExpiryDate();
    }

    private LocalDateTime calculateExpiryDate(){
        return this.createdDate.plus(EXPIRATION);
    }
}
