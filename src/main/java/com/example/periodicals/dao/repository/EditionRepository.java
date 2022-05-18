package com.example.periodicals.dao.repository;

import com.example.periodicals.dao.model.Edition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditionRepository extends CrudRepository<Edition, Integer> {

    List<Edition> findAll();

}
