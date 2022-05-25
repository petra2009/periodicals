package com.example.periodicals.dao.repository;

import com.example.periodicals.dao.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    User findUserByLogin(String login);

    void deleteById(Integer integer);
}
