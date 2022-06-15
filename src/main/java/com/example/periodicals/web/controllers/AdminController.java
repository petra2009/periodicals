package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.dao.model.User;
import com.example.periodicals.service.ApplicationService;
import com.example.periodicals.service.EditionService;
import com.example.periodicals.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.math.BigDecimal;
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

    @GetMapping("/deleteEdition{id}")
    public String getDeleteEdition(@RequestParam("id") int id) {
        System.out.println("Controller: "+id);
        editionService.deleteEditionById(id);
        return "adminPage/editions";
    }

    @ModelAttribute("edition")
    public Edition getEntityEdition() {
        return new Edition();
    }

    @GetMapping("/addEdition")
    public String getAddEdition() {
        return "addEdition";
    }

    @PostMapping("/addEdition")
    public String getSaveEdition(@Valid Edition edition, Errors error) {
        if (error.hasErrors())
            return "editions";
        editionService.addEdition(edition);
        return "redirect: admin/editions";
    }

}
