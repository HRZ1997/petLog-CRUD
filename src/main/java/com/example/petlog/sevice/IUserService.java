package com.example.petlog.sevice;

import com.example.petlog.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User save(User theUser);

    List<User> findAll();

    User findById(String theId);

    void deleteById(String theId);

}
