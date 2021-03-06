package com.ekey.repository;

import com.ekey.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface GroupsRepository extends JpaRepository<Group, Integer> {


    Optional<Group> findOneByName(String name);
}
