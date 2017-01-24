package com.jkcs.profilebuilder.service;

import com.jkcs.profilebuilder.model.Role;
import com.jkcs.profilebuilder.model.User;
import com.jkcs.profilebuilder.model.UserStatus;
import com.jkcs.profilebuilder.repository.RoleRepository;
import com.jkcs.profilebuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Amila on 1/24/17.
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =  userRepository.findUserByUsername(s);
        String password = user.getPassword();
        boolean enabled = user.getUserStatus().equals(UserStatus.ACTIVE);


        boolean accountNotExpired = user.getUserStatus().equals(UserStatus.ACTIVE);
        boolean credentialsNotExpired = user.getUserStatus().equals(UserStatus.ACTIVE);
        boolean accountNotLocked = user.getUserStatus().equals(UserStatus.ACTIVE);


        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role: roleRepository.findAll()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }


//        org.springframework.security.core.userdetails.User securityUser =
//                new org.springframework.security.core.userdetails.User(user.getUsername(),)

        return null;
    }
}
