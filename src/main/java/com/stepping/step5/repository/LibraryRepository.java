package com.stepping.step5.repository;

import com.stepping.step5.entity.Library;
import com.stepping.step5.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    List<Library> findByUniversity(University university);

    Optional<Library> findOneByName(String name);

}
