package com.example.periodicals.dao.repository;


import com.example.periodicals.dao.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Integer> {

    List<Application> findAllById(int id);

    Application findByUserId(int id);


}
