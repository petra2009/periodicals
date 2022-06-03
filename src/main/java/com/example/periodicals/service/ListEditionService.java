package com.example.periodicals.service;

import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.dao.model.ListEdition;
import com.example.periodicals.dao.model.User;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface ListEditionService {

//    ListEdition createListEdition(User user, List<Integer> editionIds);
//
//    void addEdition(ListEdition listEdition, List<Integer> editionIds);

    void addEditionToApplication(int editionId, int numberOfMonths);

    List<ListEdition> findAll();
}