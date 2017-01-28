package com.jkcs.profilebuilder.repository;


import com.jkcs.profilebuilder.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by AmilaVM on 1/26/2017.
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
