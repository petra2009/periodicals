package com.example.periodicals.service;

import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.dao.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionServiceImpl implements EditionService {

    private EditionRepository editionRepository;

    @Autowired
    public EditionServiceImpl(EditionRepository editionRepository) {
        this.editionRepository = editionRepository;
    }

    @Override
    public List<Edition> findAllEdition() {
        return editionRepository.findAll();
    }

    @Override
    public Edition findByIdEdition(int id) {
        return editionRepository.findById(id);
    }
}
