package com.example.petlog;

import com.example.petlog.entity.*;
import com.example.petlog.repository.PetRepository;
import com.example.petlog.repository.RoleRepository;
import com.example.petlog.repository.UserInfoRepository;
import com.example.petlog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

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

            saveUser(userRepository);

            //getUserAndInfoById(userRepository, 5L);

            //saveUserInfo(userInfoRepository);
        };
    }


    private void saveUser(UserRepository userRepository) {

        Long id = 100L;

        UserInfo userInfo = new UserInfo("test_ryan", "test_zhang", "test@test.com", "123456789");
        userInfo.setLogs(new ArrayList<Log>());
        userInfo.setPets(new HashSet<>());

        User user = new User("test_ryan", "test_password", true);

        Collection<Role> roles = new HashSet<Role>();
        roles.add(new Role(1,"ROLE_ADMIN"));
        roles.add(new Role(1,"ROLE_PREMIUM"));

        user.setRoles(roles);

        user.setUserInfo(userInfo);
        userInfo.setUser(user);

        userRepository.save(user);

        System.out.println("user info saved: " + userInfo.toString());

    }

    private void savePet(PetRepository petRepository, Breed breedRepository) {
        String breedName = "BERNEDOODLE";
        Pet pet = new Pet();
        pet.setName("Noodle");
        Breed breed = new Breed(1,breedName);
        pet.setBreed(breed);

    }

    private void getUserAndInfoById(UserRepository userRepository, Long id) {

        User user = userRepository.findById(id).get();

        UserInfo userInfo = user.getUserInfo();

        System.out.println("user: " + user);
        System.out.println("user's roles: " + user.getRoles());

        System.out.println("userInfo: " + userInfo);
    }


}
