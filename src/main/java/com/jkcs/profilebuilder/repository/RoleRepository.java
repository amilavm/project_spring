package com.jkcs.profilebuilder.repository;

import com.jkcs.profilebuilder.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Amila on 1/24/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
