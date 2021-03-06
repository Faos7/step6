package com.ekey.repository;

import com.ekey.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by re5 on 20.10.16.
 */
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findOneByName(String name);
}
