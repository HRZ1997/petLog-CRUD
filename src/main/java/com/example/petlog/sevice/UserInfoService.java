package com.example.petlog.sevice;

import com.example.petlog.entity.UserInfo;
import com.example.petlog.repository.UserInfoRepository;
import com.example.petlog.sevice.intefaces.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements IUserInfoService {


    private UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoService(UserInfoRepository theUserInfoRepository) { this.userInfoRepository = theUserInfoRepository; }

    @Override
    public UserInfo save(UserInfo theUserInfo) {

        return userInfoRepository.save(theUserInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo findById(Long theId) {
        Optional<UserInfo> result = userInfoRepository.findById(theId);

        UserInfo theUserInfo = null;

        if (result.isPresent()) {
            theUserInfo = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theUserInfo;
    }


    @Override
    public void deleteById(Long theId) {

        userInfoRepository.deleteById(theId);

    }


}