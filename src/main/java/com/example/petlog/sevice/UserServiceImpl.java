package com.example.petlog.sevice;

import com.example.petlog.entity.User;
import com.example.petlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) { this.userRepository = theUserRepository; }

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
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theUser;
    }


    @Override
    public void deleteById(String theId) {

        userRepository.deleteById(theId);

    }


}