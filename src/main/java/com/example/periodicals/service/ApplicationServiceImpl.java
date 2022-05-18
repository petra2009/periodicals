package com.example.periodicals.service;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<Application> findAllApplication() {
        return applicationRepository.findAll();
    }
}
