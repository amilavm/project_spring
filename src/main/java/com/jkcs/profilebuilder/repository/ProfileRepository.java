package com.jkcs.profilebuilder.repository;

import com.jkcs.profilebuilder.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * Created by AmilaVM on 1/25/2017.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    public Profile findByProfileId(Integer id);

}
