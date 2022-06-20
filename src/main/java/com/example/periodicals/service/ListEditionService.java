package com.example.periodicals.service;

import com.example.periodicals.dao.model.ListEdition;

import java.util.List;

public interface ListEditionService {

//    ListEdition createListEdition(User user, List<Integer> editionIds);
//
//    void addEdition(ListEdition listEdition, List<Integer> editionIds);

    void addEditionToApplication(int editionId, int numberOfMonths);

    List<ListEdition> findAll();

    List<ListEdition> findAllByApplicationId(int applicationId);

    void deleteById(int id);

    void payApplication();

   // ListEdition findListEditionById(int id);


}