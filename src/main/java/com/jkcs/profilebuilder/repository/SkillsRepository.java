package com.jkcs.profilebuilder.repository;

import com.jkcs.profilebuilder.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AmilaVM on 1/31/2017.
 */
@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {

}
