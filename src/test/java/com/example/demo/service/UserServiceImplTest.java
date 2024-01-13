package com.example.demo.service;

import com.example.demo.configuration.TestConfig;
import com.example.demo.model.User;
import com.example.demo.repositories.iUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ActiveProfiles("test")
@Import(TestConfig.class)
public class UserServiceImplTest {

    @MockBean
    private iUserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void getUserById() {
        Integer id = 1;
        User user = new User();
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        Mockito.when(userRepository.findUserById(id)).thenReturn(user);
        User testUser = userService.getUserById(id);
        Mockito.verify(userRepository).findUserById(id);
        Assertions.assertEquals(testUser, user);
    }

    @Test
    public void findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<User> testUsers = userService.findAll();
        Mockito.verify(userRepository).findAll();
        Assertions.assertEquals(testUsers, users);
    }

    @Test
    public void saveUser() {
        User user = new User();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User testUser = userService.saveUser(user);
        Mockito.verify(userRepository).save(user);
        Assertions.assertEquals(testUser, user);
    }

    @Test
    public void deleteById() {
        int id = 1;
        userRepository.deleteById(id);
        Mockito.verify(userRepository).deleteById(id);
    }

    @Test
    public void updateUser() {
        User user = new User();
        userRepository.update(user);
        Mockito.verify(userRepository).update(user);
    }
}
