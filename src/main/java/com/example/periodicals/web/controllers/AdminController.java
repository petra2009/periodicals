package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.dao.model.User;
import com.example.periodicals.service.ApplicationService;
import com.example.periodicals.service.EditionService;
import com.example.periodicals.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private EditionService editionService;
    private UserService userService;
    private ApplicationService applicationService;


    public AdminController(EditionService editionService, UserService userService, ApplicationService applicationService) {
        this.editionService = editionService;
        this.userService = userService;
        this.applicationService = applicationService;
    }

    @GetMapping()
    public String getAdminPage() {
        return "adminPage";
    }

    @GetMapping("/editions")
    public String getAdminPageEdition(Model model) {
        List<Edition> editionList = editionService.findAllEdition();
        model.addAttribute("editList", editionList);
        return "adminPage";
    }

    @GetMapping("/users")                            //список всех подписчиков
    public String getAdminPageUsers(Model model) {
        List<User> allUser = userService.findAllUser();
        model.addAttribute("users", allUser);
        return "adminPage";
    }

    @GetMapping("/userDelete{id}")
    public String getDeleteUserById(@RequestParam("id") int id) {
        userService.deleteUserById(id);
        return "adminPage";
    }

    @GetMapping("/applications")                        //выполненые подписки
    public String getApplicotionsUssers(Model model) {
        List<Application> applications = applicationService.findAllApplication();
        model.addAttribute("applications", applications);
        return "adminPage";
    }


}
