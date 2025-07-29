package com.codewithtopgyal.store.repositories;

import com.codewithtopgyal.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}