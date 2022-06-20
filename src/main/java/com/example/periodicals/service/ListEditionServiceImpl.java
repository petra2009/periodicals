package com.example.periodicals.service;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.model.ListEdition;
import com.example.periodicals.dao.model.User;
import com.example.periodicals.dao.repository.ApplicationRepository;
import com.example.periodicals.dao.repository.EditionRepository;
import com.example.periodicals.dao.repository.ListEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ListEditionServiceImpl implements ListEditionService {

    private final ListEditionRepository listEditionRepository;
    private final EditionRepository editionRepository;
    private final UserService userService;
    private final ApplicationRepository applicationRepository;


    @Autowired
    public ListEditionServiceImpl(ListEditionRepository listEditionRepository, EditionRepository editionRepository, UserService userService, ApplicationRepository applicationRepository) {
        this.listEditionRepository = listEditionRepository;
        this.editionRepository = editionRepository;
        this.userService = userService;
        this.applicationRepository = applicationRepository;
    }

//    @Override
//    public ListEdition addListEdition(ListEdition listEdition) {
//        ListEdition saveListEdition = listEditionRepository.save(listEdition);
//        return saveListEdition;
//    }

    @Override
    public void addEditionToApplication(int editionId, int numberOfMonths) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();   //челик из UserDetails
        User user = userService.findUserByLogin(auth.getName());                        //челик из БД
        int applicationId = user.getCurrentApplicationId();                             //текущий статус заказа (0 - пустой, !0 - имеет список)
        Application application;
        if (applicationId == 0) {
            application = new Application(LocalDate.now(), user);
            applicationRepository.save(application);
        } else
            application = applicationRepository.findById(applicationId).get();
        ListEdition listEdition = new ListEdition();
        listEdition.setApplication(application);
        listEdition.setEdition(editionRepository.findById(editionId).get());
        listEdition.setNumberOfMonths(numberOfMonths);
        listEditionRepository.save(listEdition);
        user.setCurrentApplicationId(application.getId());
        userService.save(user);
    }

    @Override
    public List<ListEdition> findAll() {
        return (List<ListEdition>) listEditionRepository.findAll();
    }

//    @Override
//    public void deleteListEdition(ListEdition listEdition) {
//        listEditionRepository.deleteListEdition(listEdition);
//    }

    @Override
    public List<ListEdition> findAllByApplicationId(int applicationId) {
        List<ListEdition> listEditionApplication = listEditionRepository.findAllByApplicationId(applicationId);
        return listEditionApplication;
    }

    @Override
    public void deleteById(int id) {
        listEditionRepository.deleteById(id);
    }

    @Override
    public void payApplication(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();   //челик из UserDetails
        User user = userService.findUserByLogin(auth.getName());
        user.setCurrentApplicationId(0);
        userService.save(user);
    }
}
