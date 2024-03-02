package com.example.petlog.sevice;

import com.example.petlog.entity.User;
import com.example.petlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository theUserRepository) { this.userRepository = theUserRepository; }

    @Override
    public User save(User theUser) {

        return userRepository.save(theUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theUser;
    }


    @Override
    public void deleteById(String theId) {

        userRepository.deleteById(theId);

    }

    @Override
    public boolean verify(String username, String password) {

        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new RuntimeException("Did not find username - " + username);
        }

        return user.getPassword().equals(password);

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }


}