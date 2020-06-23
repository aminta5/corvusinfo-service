package com.corvusinfo.registrationapi.repositories;

import com.corvusinfo.registrationapi.model.OauthClientDetails;
import org.springframework.data.repository.CrudRepository;

public interface OauthClientDetailsRepository extends CrudRepository<OauthClientDetails, String> {
}
