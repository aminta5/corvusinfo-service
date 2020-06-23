package com.corvusinfo.registrationapi.security;

import com.corvusinfo.registrationapi.model.OauthClientDetails;
import com.corvusinfo.registrationapi.repositories.OauthClientDetailsRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service("cds")
public class ClientDetailsServiceImpl implements ClientDetailsService {
    private final OauthClientDetailsRepository repository;

    public ClientDetailsServiceImpl(OauthClientDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClientDetails oauthClientDetails = repository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        return new ClientDetailsImpl(oauthClientDetails);
    }
}
