package com.jkcs.profilebuilder.service;

import com.jkcs.profilebuilder.model.Skills;
import com.jkcs.profilebuilder.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AmilaVM on 2/2/2017.
 */
@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public List<Skills> getAllSkills(){
        return skillsRepository.findAll();
    }



}
