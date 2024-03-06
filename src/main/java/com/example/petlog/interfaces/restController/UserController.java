package com.example.petlog.interfaces.restController;

import com.example.petlog.entity.DTOs.RegisterDTO;
import com.example.petlog.entity.User;
import com.example.petlog.entity.UserInfo;
import com.example.petlog.sevice.UserInfoService;
import com.example.petlog.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserInfoService userInfoService;
    private UserService userService;

    @Autowired
    public UserController(UserInfoService theUserInfoService, UserService theUserService) {
        this.userInfoService = theUserInfoService;
        this.userService = theUserService;
    }

    @PostMapping("/register")
    public void addUser(@RequestBody RegisterDTO registerDTO) {

        User user = new User();
        UserInfo userInfo = new UserInfo();

        //set user from DTO
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setEnabled(true);

        //set userInfo from DTO
        userInfo.setFirstName(registerDTO.getFirstName());
        userInfo.setLastName(registerDTO.getLastName());
        userInfo.setEmail(registerDTO.getEmail());
        userInfo.setPhone(registerDTO.getPhone());
        userInfo.setBirthday(registerDTO.getBirthday());

        User userCreated = userService.createUser(user, userInfo);
        if (userCreated == null) {
            throw new RuntimeException("User not created - " + user.getUsername());
        }

    }

    @PostMapping("/login")
    public void login(@PathVariable String username, @PathVariable String password){

    }

    @GetMapping("/login")
    public void login(){

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
