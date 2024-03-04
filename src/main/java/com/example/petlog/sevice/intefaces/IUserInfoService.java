package com.example.petlog.sevice.intefaces;

import com.example.petlog.entity.UserInfo;

import java.util.List;

public interface IUserInfoService {
    UserInfo save(UserInfo theUserInfo);

    List<UserInfo> findAll();

    UserInfo findById(Long theId);

    void deleteById(Long theId);


}
