package com.jkcs.profilebuilder.repository;

import com.jkcs.profilebuilder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * Created by Amila on 1/24/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByUsername(String username);
}
