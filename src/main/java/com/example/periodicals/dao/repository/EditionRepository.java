package com.example.periodicals.dao.repository;

import com.example.periodicals.dao.model.Edition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionRepository extends CrudRepository<Edition, Integer> {

}
