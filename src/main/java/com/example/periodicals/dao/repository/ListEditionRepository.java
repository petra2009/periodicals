package com.example.periodicals.dao.repository;

import com.example.periodicals.dao.model.ListEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListEditionRepository extends CrudRepository<ListEdition, Integer> {


}
