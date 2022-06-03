package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.model.ListEdition;
import com.example.periodicals.dao.model.User;
import com.example.periodicals.service.ApplicationService;
import com.example.periodicals.service.EditionService;
import com.example.periodicals.service.ListEditionService;
import com.example.periodicals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListEditionController {

    private ListEditionService listEditionService;
    private UserService userService;
    private ApplicationService applicationService;
    private EditionService editionService;


    @Autowired
    public ListEditionController(ListEditionService listEditionService, UserService userService, ApplicationService applicationService, EditionService editionService) {
        this.listEditionService = listEditionService;
        this.userService = userService;
        this.applicationService = applicationService;
        this.editionService = editionService;
    }

    @GetMapping("/listEdition")
    public String getListEdition(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  //челик из UserDetails
        User user = userService.findUserByLogin(auth.getName());

        List<Application> applicationList = applicationService.findAllApplication();
        List<Application> applicationListUser = applicationList.stream().filter(app -> app.getUser().getId()== user.getId()).collect(Collectors.toList());
        Application application =applicationListUser.stream().skip(applicationListUser.size()-1).findAny().orElse(null);
        List<ListEdition> listEditions = listEditionService.findAll();
        List<ListEdition> listEditionUser = listEditions.stream().filter(list -> list.getApplication().getId()==application.getId()).collect(Collectors.toList());
        model.addAttribute("editList", listEditionUser);
        return "listEdition";
    }
////        model.addAttribute("applications", applications);
////
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  //челик из UserDetails
////        User user = userService.findUserByLogin(auth.getName());
////        List<Application> applicationUser = applicationService.findAllById(id)
////
////
////        List<ListEdition> listEditions = listEditionService.findAllListEdition();
//        model.addAttribute("listEdition", applications);
//




}
