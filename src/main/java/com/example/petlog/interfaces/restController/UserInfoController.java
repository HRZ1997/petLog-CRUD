package com.example.petlog.interfaces.restController;

import com.example.petlog.entity.UserInfo;
import com.example.petlog.sevice.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserInfoController {

    private UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService theUserInfoService) { this.userInfoService = theUserInfoService; }

    @PostMapping("/users")
    public UserInfo addUser(@RequestBody UserInfo theUserInfo) {


        return userInfoService.save(theUserInfo);

    }

    @GetMapping("/users")
    public List<UserInfo> findAll() {
        return userInfoService.findAll();
    }

    @GetMapping("/users/{userId}")
    public UserInfo getUser(@PathVariable Long userId) {

        UserInfo theUserInfo = userInfoService.findById(userId);

        if (theUserInfo == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return theUserInfo;
    }


    @PutMapping("/users")
    public UserInfo updateUser(@RequestBody UserInfo theUserInfo) {

        UserInfo dbUserInfo = userInfoService.save(theUserInfo);

        return dbUserInfo;
    }

    // add mapping for DELETE /users/{userId} - delete user

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {

        UserInfo tempUserInfo = userInfoService.findById(userId);

        // throw exception if null

        if (tempUserInfo == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userInfoService.deleteById(userId);

        return "Deleted user id - " + userId;
    }
}
