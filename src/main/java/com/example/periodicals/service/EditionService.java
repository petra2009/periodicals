package com.example.periodicals.service;

import com.example.periodicals.dao.model.Edition;

import java.util.List;
import java.util.Optional;

public interface EditionService {

    List<Edition> findAllEdition();
    Optional<Edition> findEditionById(int id);
    Edition editEdition(Edition edition);
    void deleteEditionById(int id);
    Edition addEdition(Edition edition);
}
