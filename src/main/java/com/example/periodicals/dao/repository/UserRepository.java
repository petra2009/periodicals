package com.example.periodicals.dao.repository;

import com.example.periodicals.dao.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByLogin(String login);

    @Override
    Optional<User> findById(Integer integer);

    User save(User user);


}
