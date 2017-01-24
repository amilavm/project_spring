package com.jkcs.profilebuilder.service;

import com.jkcs.profilebuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Amila on 1/24/17.
 */
@Service
public class TestService {

    @Autowired
    private UserRepository userRepository;

    public int getUsersCount(){
        return (int)userRepository.count()*2;
    }

}
