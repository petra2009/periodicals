package com.example.periodicals.service;

import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.dao.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditionServiceImpl implements EditionService {

    private EditionRepository editionRepository;

    @Autowired
    public EditionServiceImpl(EditionRepository editionRepository) {
        this.editionRepository = editionRepository;
    }

    @Override
    public List<Edition> findAllEdition() {
        return (List<Edition>) editionRepository.findAll();
    }

    public Optional<Edition> findEditionById(int id) {
        return editionRepository.findById(id);
    }

    @Override
    public Edition editEdition(Edition edition) {
        return editionRepository.save(edition);
    }

    @Override
    public Edition addEdition(Edition edition) {
        return editionRepository.save(edition);
    }

    @Override
    public void deleteEditionById(int id) {
        editionRepository.deleteById(id);
    }
}
