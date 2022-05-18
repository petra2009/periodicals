package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.User;
import com.example.periodicals.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public String getAllUser(Model model) {
        List<User> allUser = userService.findAllUser();
        model.addAttribute("users", allUser);
        return "users";
    }
}
