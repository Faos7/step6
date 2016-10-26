package com.stepping.step5.repository;

import com.stepping.step5.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by re5 on 20.10.16.
 */
@Transactional
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Optional<Faculty> findOneByName(String name);
}
