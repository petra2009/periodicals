package com.example.periodicals.service;

import com.example.periodicals.dao.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAllUser();
    User findUserByLogin(String login);
    void save(User user);

}
