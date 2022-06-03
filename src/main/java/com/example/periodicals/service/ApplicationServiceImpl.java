package com.example.periodicals.service;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.model.ListEdition;
import com.example.periodicals.dao.model.User;
import com.example.periodicals.dao.repository.ApplicationRepository;
import com.example.periodicals.dao.repository.ListEditionRepository;
import com.example.periodicals.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private UserRepository userRepository;
    private ListEditionRepository listEditionRepository;
    private UserService userService;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository, UserRepository userRepository, ListEditionRepository listEditionRepository, UserService userService) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.listEditionRepository = listEditionRepository;
        this.userService = userService;
    }

    @Override
    public Application createApplication (User user) {
        Application application = new Application();
        application.setUser(user);
        application.setDate(LocalDate.now());
        return applicationRepository.save(application);
    }

    @Override
    public Application addApplication(Application application) {
        Application saveApplication = applicationRepository.save(application);
        return saveApplication;
    }

    @Override
    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public Application editApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> findAllApplication() {
        List<Application> applications = (List<Application>) applicationRepository.findAll();
        return applications;
    }

    @Override
    public List<Application> findAllByUserId(int id) {
        List<Application> applicationsUserId = applicationRepository.findAllById(id);
        return null;
    }

    @Override
    public Application findByUserId(int id) {

        return null;
    }
}
