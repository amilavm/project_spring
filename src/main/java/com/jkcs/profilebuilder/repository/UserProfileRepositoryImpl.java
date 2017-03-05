package com.jkcs.profilebuilder.repository;

import com.jkcs.profilebuilder.model.UserProfile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by AmilaVM on 1/26/2017.
 */

@Repository
public class UserProfileRepositoryImpl {

    @Autowired
    private SessionFactory sessionFactory;


    public void saveProfile(UserProfile userProfile){
        sessionFactory.getCurrentSession().saveOrUpdate(userProfile);
    }


}
