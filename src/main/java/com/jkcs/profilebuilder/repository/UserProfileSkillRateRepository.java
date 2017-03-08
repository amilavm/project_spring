package com.jkcs.profilebuilder.repository;

import com.jkcs.profilebuilder.model.UserprofileSkillRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AmilaVM on 3/5/2017.
 */
@Repository
public interface UserProfileSkillRateRepository extends JpaRepository<UserprofileSkillRate,Integer> {
}
