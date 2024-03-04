package com.example.petlog.sevice.intefaces;

import com.example.petlog.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    public User findByUsername(String username);
}
