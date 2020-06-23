package com.corvusinfo.registrationapi.security;

import com.corvusinfo.registrationapi.model.OauthClientDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

public class ClientDetailsImpl implements ClientDetails {
    private String clientId;
    private String resourceId;
    private String clientSecret;
    private String scope;
    private String authorizedGrandTypes;
    private int accessTokenValidity;
    private int refreshTokenValidity;

    public ClientDetailsImpl(OauthClientDetails oauthClientDetails) {
        this.clientId = oauthClientDetails.getClientId();
        this.resourceId = oauthClientDetails.getResourceIds();
        this.clientSecret = oauthClientDetails.getClientSecret();
        this.scope = oauthClientDetails.getScope();
        this.authorizedGrandTypes = oauthClientDetails.getAuthorizedGrantTypes();
        this.accessTokenValidity = oauthClientDetails.getAccessTokenValidity();
        this.refreshTokenValidity = oauthClientDetails.getRefreshTokenValidity();
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<>(Arrays.asList(this.scope.split(",")));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<>(Arrays.asList(this.authorizedGrandTypes.split(",")));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>();
    }
}
