package com.jkcs.profilebuilder.repository;

import com.jkcs.profilebuilder.model.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AmilaVM on 2/2/2017.
 */
@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Integer> {
}
