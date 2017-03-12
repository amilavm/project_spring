package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.model.UserprofileSkillRate;
import com.jkcs.profilebuilder.repository.UserProfileSkillRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AmilaVM on 3/5/2017.
 */
@RestController
public class UserProfileSkillRateController {

    private UserProfileSkillRateRepository userProfileSkillRateRepository;

    @Autowired
    public void setUserProfileSkillRateRepository(UserProfileSkillRateRepository userProfileSkillRateRepository) {
        this.userProfileSkillRateRepository = userProfileSkillRateRepository;
    }


    @RequestMapping(value = "/userprofile/skillRate/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSkill(@RequestBody UserprofileSkillRate userprofileSkillRate) {


        UserprofileSkillRate usr = userProfileSkillRateRepository.save(userprofileSkillRate);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}


