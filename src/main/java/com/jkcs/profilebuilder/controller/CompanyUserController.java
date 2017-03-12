package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.model.CompanyUserProfile;
import com.jkcs.profilebuilder.repository.CompanyUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by AmilaVM on 3/9/2017.
 */
@RestController
public class CompanyUserController {

    private CompanyUserProfileRepository companyUserProfileRepository;
    @Autowired
    public void setCompanyUserProfileRepository(CompanyUserProfileRepository companyUserProfileRepository) {
        this.companyUserProfileRepository = companyUserProfileRepository;
    }

    //-------------Retrieve all company users------------------------//

    @RequestMapping(value = "/companyusers" , method = RequestMethod.GET)
    public ResponseEntity<List<CompanyUserProfile>> listAllCOmpanyUsers(){
        List<CompanyUserProfile> comUsers = companyUserProfileRepository.findAll();
        if (comUsers.isEmpty()){
            return new ResponseEntity<List<CompanyUserProfile>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CompanyUserProfile>>(comUsers,HttpStatus.OK);
    }

    //-------------Retrieve single company user---------------------//

    @RequestMapping(value = "/companyusers/{id}" , method = RequestMethod.GET)
    public ResponseEntity<CompanyUserProfile> getUserProfile(@PathVariable("id") Integer id){
        System.out.println("Retrieving company user with id " +id);
        CompanyUserProfile companyUser = companyUserProfileRepository.findOne(id);
        if (companyUser == null){
            System.out.println("company user with id " +id+ "not found");
            return new ResponseEntity<CompanyUserProfile>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CompanyUserProfile>(companyUser, HttpStatus.OK);
    }

    //-------------create a user------------------------------------//

    @RequestMapping(value = "/companyusers" , method = RequestMethod.POST)
    public ResponseEntity<Void> createCompanyUser(@RequestBody CompanyUserProfile companyUserProfile, UriComponentsBuilder ucBuilder){
        System.out.println("Creating company user " +companyUserProfile.getCom_userName());

        companyUserProfileRepository.save(companyUserProfile);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation((ucBuilder.path("/companyusers/{id}").buildAndExpand(companyUserProfile.getId()).toUri()));
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------update a user-----------------------------------//

    @RequestMapping(value = "/companyusers/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<CompanyUserProfile> updateCompanyUserprofile(@PathVariable("id") Integer id, @RequestBody CompanyUserProfile companyUserProfile){
        System.out.println("Updating company userprofile with id " +id);

        CompanyUserProfile currentComUser = companyUserProfileRepository.findOne(id);

        if (currentComUser == null){
            System.out.println("Company user with id " +id+ "not found");
            return new ResponseEntity<CompanyUserProfile>(HttpStatus.NOT_FOUND);
        }

        currentComUser.setCom_CompanyName(companyUserProfile.getCom_CompanyName());
        currentComUser.setCom_location(companyUserProfile.getCom_location());
        currentComUser.setCom_telNo(companyUserProfile.getCom_telNo());
        currentComUser.setCom_userName(companyUserProfile.getCom_userName());
        currentComUser.setCom_email(companyUserProfile.getCom_email());

        companyUserProfileRepository.save(currentComUser);
        return new ResponseEntity<CompanyUserProfile>(currentComUser, HttpStatus.OK);
    }

    //-------------delete a company user--------------------------//

    @RequestMapping(value = "/companyusers/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<CompanyUserProfile> deleteCompanyUser(@PathVariable("id") Integer id){
        System.out.println("deleting company user with id " +id);

        CompanyUserProfile companyUserProfile = companyUserProfileRepository.findOne(id);
        if (companyUserProfile == null){
            System.out.println("unable to delete. Company user with id " +id+ "not found");
        }

        companyUserProfileRepository.delete(id);
        return new ResponseEntity<CompanyUserProfile>(HttpStatus.NO_CONTENT);
    }

    //-------------delete all users-----------------------------//

    @RequestMapping(value = "/companyusers/" , method = RequestMethod.DELETE)
    public ResponseEntity<CompanyUserProfile> deleteAllUsers(){
        System.out.println("deleting all users");

        companyUserProfileRepository.deleteAll();
        return new ResponseEntity<CompanyUserProfile>(HttpStatus.NO_CONTENT);
    }
}
