package com.example.periodicals.dao.repository;

import com.example.periodicals.dao.model.ListEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListEditionRepository extends CrudRepository<ListEdition, Integer> {

    List<ListEdition> findAllByApplicationId(int applicationId);




   // void deleteListEdition(ListEdition listEdition);

   // ListEdition findListEditionById(int id);



}
