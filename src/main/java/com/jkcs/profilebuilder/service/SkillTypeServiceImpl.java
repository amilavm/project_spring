package com.jkcs.profilebuilder.service;

import com.jkcs.profilebuilder.model.SkillType;
import com.jkcs.profilebuilder.repository.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AmilaVM on 2/2/2017.
 */
@Service
public class SkillTypeServiceImpl {

    @Autowired
    private SkillTypeRepository skillTypeRepository;


    public List<SkillType> getAllSkills(){
        return skillTypeRepository.findAll();
    }

}
