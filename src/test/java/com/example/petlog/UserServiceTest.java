package com.example.petlog;

import com.example.petlog.repository.UserRepository;
import com.example.petlog.sevice.IUserService;
import com.example.petlog.sevice.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = PetLogCrudApplicationTests.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void test_verify() {
        userService.verify("admin", "1234");

    }
}
