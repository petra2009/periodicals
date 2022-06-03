package com.example.periodicals.dao.repository;

import com.example.periodicals.dao.model.BlackList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends CrudRepository<BlackList, Integer> {

}
