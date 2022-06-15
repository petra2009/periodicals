package com.example.periodicals.service;

import com.example.periodicals.dao.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void addUser(User user);
    List<User> findAllUser();
    Optional<User> findById(int id);
    User save(User user);
    void deleteUserById(int id);

    User findUserByLogin(String login);







}
