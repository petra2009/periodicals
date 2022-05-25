package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApplicationController {

    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/application/all")
    public String getAllApplication(Model model) {
        List<Application> applicationList = applicationService.findAllApplication();
        model.addAttribute("allAplication", applicationList);
        System.out.println(applicationList);
        return "applications";
    }


}
