package com.corvusinfo.registrationapi.repositories;

import com.corvusinfo.registrationapi.model.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {
}
