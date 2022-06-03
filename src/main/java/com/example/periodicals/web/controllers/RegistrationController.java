package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Role;
import com.example.periodicals.dao.model.User;
import com.example.periodicals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User getEntityUser() {
        return new User();
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/userRegister")
    public String getRegisterUser(@Valid User user, Errors errors) {
        if (errors.hasErrors())
            return "register";
        user.setRole(Role.ROLE_USER);
        userService.addUser(user);
        return "login";
    }
}
