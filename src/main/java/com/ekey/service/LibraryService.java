package com.ekey.service;

import com.ekey.models.out.LibraryOut;

import java.util.Collection;

/**
 * Created by re5 on 02.11.16.
 */
public interface LibraryService {

    LibraryOut getLibraryById(Integer id);

    Collection<LibraryOut> getAllLibraries();

    Collection<LibraryOut> getAllUniversityLibraries(Integer id);

}
