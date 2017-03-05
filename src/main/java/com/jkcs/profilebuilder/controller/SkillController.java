package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.service.SkillTypeServiceImpl;
import com.jkcs.profilebuilder.service.SkillsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AmilaVM on 2/2/2017.
 */
@RestController
public class SkillController {


    private SkillsServiceImpl skillsService;

    @Autowired
    public void setSkillsService(SkillsServiceImpl skillsService) {
        this.skillsService = skillsService;
    }

    private SkillTypeServiceImpl skillTypeService;

    @Autowired
    public void setSkillTypeService(SkillTypeServiceImpl skillTypeService) {
        this.skillTypeService = skillTypeService;
    }




}
