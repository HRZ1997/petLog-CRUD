package com.example.petlog.rest;

import com.example.petlog.entity.User;
import com.example.petlog.entity.User;
import com.example.petlog.sevice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl theUserService) { this.userService = theUserService; }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        theUser.setId(UUID.randomUUID().toString());

        User dbUser = userService.save(theUser);

        return dbUser;

    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId) {

        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return theUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        User dbUser = userService.save(theUser);

        return dbUser;
    }

    // add mapping for DELETE /users/{userId} - delete user

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId) {

        User tempUser = userService.findById(userId);

        // throw exception if null

        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }
}
