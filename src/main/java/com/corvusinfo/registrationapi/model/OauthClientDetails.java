package com.corvusinfo.registrationapi.model;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class OauthClientDetails {
    @Id
    @Column
    @NotNull
    private String clientId;

    @Column
    private String resourceIds;
    @Column
    @NotNull
    private String clientSecret;
    @Column
    @NotNull
    private String scope;
    @Column
    @NotNull
    private String authorizedGrantTypes;
    @Column
    private int accessTokenValidity;
    @Column
    private int refreshTokenValidity;
}
