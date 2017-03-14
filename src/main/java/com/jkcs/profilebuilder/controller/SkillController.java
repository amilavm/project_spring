package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.model.Skills;
import com.jkcs.profilebuilder.model.UserProfile;
import com.jkcs.profilebuilder.model.UserprofileSkillRate;
import com.jkcs.profilebuilder.repository.SkillsRepository;
import com.jkcs.profilebuilder.repository.UserProfileRepository;
import com.jkcs.profilebuilder.repository.UserProfileSkillRateRepository;
import com.jkcs.profilebuilder.service.SkillTypeServiceImpl;
import com.jkcs.profilebuilder.service.SkillsServiceImpl;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AmilaVM on 2/2/2017.
 */
@RestController
public class SkillController {


    private SkillsRepository skillsRepository;
    @Autowired
    public void setSkillsRepository(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

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

    private UserProfileSkillRateRepository userProfileSkillRateRepository;
    @Autowired
    public void setUserProfileSkillRateRepository(UserProfileSkillRateRepository userProfileSkillRateRepository) {
        this.userProfileSkillRateRepository = userProfileSkillRateRepository;
    }

    private UserProfileRepository userProfileRepository;
    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    //----cfeate a skill----//
@RequestMapping(value = "/userprofile/skill/", method = RequestMethod.POST)
public ResponseEntity<Void> createSkill(@RequestBody Skills skill){
    //System.out.println(skill.getId());

    Skills sk = skillsRepository.save(skill);
    System.out.println("created skill "+sk.getSkillName());
   // UserprofileSkillRate a = new UserprofileSkillRate();

   // UserProfile up = userProfileRepository.findOne(1);
   // a.setSkill(sk);
    //userProfileSkillRateRepository.save(a);

    return new ResponseEntity<Void>(HttpStatus.CREATED);

}


}
