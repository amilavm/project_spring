package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.model.User;
import com.jkcs.profilebuilder.repository.UserRepository;
import com.jkcs.profilebuilder.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Amila on 1/24/17.
 */
@RestController
public class HomeController {

    @Autowired
    private TestService testService;

    @RequestMapping("index")
    public String index(){

        System.out.println(testService.getUsersCount());
//
//        List<User> users = userRepository.findAll();
//        for(User u:users){
//            System.out.println(u.getUsername());
//        }

        return "index";
    }
}
