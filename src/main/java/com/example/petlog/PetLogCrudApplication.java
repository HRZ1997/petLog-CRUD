package com.example.petlog;

import com.example.petlog.entity.Role;
import com.example.petlog.entity.User;
import com.example.petlog.entity.UserInfo;
import com.example.petlog.repository.RoleRepository;
import com.example.petlog.repository.UserInfoRepository;
import com.example.petlog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PetLogCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetLogCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, UserInfoRepository userInfoRepository, RoleRepository roleRepository) {

        return runner -> {
            // createInstructor(appDAO);

            // findInstructor(appDAO);

            //saveUser(userRepository, roleRepository);

            //getUserAndInfoById(userRepository, 5L);

            //saveUserInfo(userInfoRepository);
        };
    }


    private void saveUser(UserRepository userRepository, RoleRepository roleRepository) {

        Long id = 100L;

        UserInfo userInfo = new UserInfo("test_ryan", "test_zhang", "test@test.com", "123456789");

        User user = new User("test_ryan", "test_password", true);

        Collection<Role> roles = new HashSet<Role>();

        roles.add(roleRepository.findById(1).get());
        roles.add(roleRepository.findById(2).get());

        user.setRoles(roles);

        user.setUserInfo(userInfo);
        userInfo.setUser(user);

        userRepository.save(user);

        System.out.println("user info saved: " + userInfo.toString());

    }

    private void getUserAndInfoById(UserRepository userRepository, Long id) {

        User user = userRepository.findById(id).get();

        UserInfo userInfo = user.getUserInfo();

        System.out.println("user: " + user);
        System.out.println("user's roles: " + user.getRoles());

        System.out.println("userInfo: " + userInfo);
    }


}
