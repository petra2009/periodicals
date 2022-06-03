package com.example.periodicals.service;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.model.User;

import java.util.List;

public interface ApplicationService {

    Application addApplication(Application application);
    void deleteApplication(int id);
    Application editApplication(Application application);

    List<Application> findAllApplication();

    Application createApplication(User user);

    List<Application> findAllByUserId(int id);

    Application findByUserId(int id);


}
