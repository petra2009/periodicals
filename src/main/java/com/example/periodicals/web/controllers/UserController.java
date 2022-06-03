package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.User;
import com.example.periodicals.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")         //вывод информации о текущем пользователе
    public String getUserByLogin(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  //челик из UserDetails
        User user = userService.findUserByLogin(auth.getName());
        System.out.println(user);
        model.addAttribute("users", user);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateUserProfile(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "email") String email) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  //челик из UserDetails
        User user = userService.findUserByLogin(auth.getName());
        user.setName(name);
        user.setEmail(email);
        userService.save(user);
        return "redirect:/profile";
    }
}
