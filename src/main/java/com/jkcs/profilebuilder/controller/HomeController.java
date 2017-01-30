package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.model.User;
import com.jkcs.profilebuilder.model.UserProfile;
import com.jkcs.profilebuilder.repository.UserProfileRepository;
import com.jkcs.profilebuilder.repository.UserProfileRepositoryImpl;
import com.jkcs.profilebuilder.repository.UserRepository;
import com.jkcs.profilebuilder.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Amila on 1/24/17.
 */
@RestController
public class HomeController {


    private UserProfileRepository userProfileRepository;

    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

//    @Autowired
//    private UserProfileRepositoryImpl userProfileRepository;

 //   @RequestMapping("index")
//    public String index(){
//
//        userProfileRepository.saveProfile(new UserProfile());
//        List<User> users = userRepository.findAll();
//
//
//        for(User u:users){
//            System.out.println(u.getUsername());
//        }
//
//        return "index";
//    }

    //------Retrieve All Users------
    @RequestMapping(value = "/userprofile/", method = RequestMethod.GET)
    public ResponseEntity<List<UserProfile>> listAllUsers(){
        List<UserProfile> users = userProfileRepository.findAll();
        if (users.isEmpty()){
            return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserProfile>>(users,HttpStatus.OK);
    }

    //------Retrieve Single User------
    @RequestMapping(value = "/userprofile/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserProfile> getUserprofile(@PathVariable("id") Integer id){
        System.out.println("Fetching user with id " +id);
        UserProfile userProfile = userProfileRepository.findOne(id);
        if (userProfile == null){
            System.out.println("Userprofile with id " +id+ "not found");
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
    }

    //------Create A User------
    @RequestMapping(value = "/userprofile/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUserProfile(@RequestBody UserProfile userprofile, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Userprofile " +userprofile.getFirstname()+" "+userprofile.getLastname());

        userProfileRepository.save(userprofile);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/userprofiles/{id}").buildAndExpand(userprofile.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }

    //------Update A User------
    @RequestMapping(value = "/userprofile/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable("id") Integer id, @RequestBody UserProfile userProfile){
        System.out.println("Updating a User " +id);

        UserProfile currentUser = userProfileRepository.findOne(id);

        if (currentUser == null){
            System.out.println("User with id " +id+ "not found");
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }

        currentUser.setFirstname(userProfile.getFirstname());
        currentUser.setLastname(userProfile.getLastname());
        currentUser.setEmail(userProfile.getEmail());
        currentUser.setAddress(userProfile.getAddress());
        currentUser.setCountry(userProfile.getCountry());
        currentUser.setDob(userProfile.getDob());
        currentUser.setGender(userProfile.getGender());
        currentUser.setPhone(userProfile.getPhone());

        userProfileRepository.save(userProfile);
        return new ResponseEntity<UserProfile>(currentUser, HttpStatus.OK);
    }

    //
    @RequestMapping(value = "/userprofile/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserProfile> deleteUserProfile(@PathVariable("id") Integer id){
        System.out.println("Fetching and Deleting User profile with id "+id);

        UserProfile userProfile = userProfileRepository.findOne(id);
        if (userProfile == null){
            System.out.println("Unable to delete user profile with id "+id);
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }

        userProfileRepository.delete(id);
        return new ResponseEntity<UserProfile>(HttpStatus.OK);
    }

    //
    @RequestMapping(value = "/userprofile/", method = RequestMethod.DELETE)
    public ResponseEntity<UserProfile> deleteAllUsers(){
        System.out.println("Deleting All User Profiles");

        userProfileRepository.deleteAll();
        return new ResponseEntity<UserProfile>(HttpStatus.NO_CONTENT);
    }

}



