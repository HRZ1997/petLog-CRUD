package com.example.petlog.repository;

import com.example.petlog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Queue;

public interface UserRepository extends JpaRepository<User, String> {

    User getUserByUsername(String username);

}
