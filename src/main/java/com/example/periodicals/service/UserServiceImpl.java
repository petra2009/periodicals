package com.example.periodicals.service;

import com.example.periodicals.dao.model.Role;
import com.example.periodicals.dao.model.User;
import com.example.periodicals.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> findAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername (String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login);   //челик из БД
        Set<Role> roles = new HashSet<>();
        if (user==null)
            throw new UsernameNotFoundException("not user");
        else
            System.out.println("OK");
        roles.add(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPass(), roles);
    }

    @Override
    public void addUser(User user){
        user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }
}
