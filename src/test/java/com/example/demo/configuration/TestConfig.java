package com.example.demo.configuration;

import com.example.demo.repositories.UserRepositoryImpl;
import com.example.demo.repositories.iUserRepository;
import com.example.demo.service.UserServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public iUserRepository userRepository(){
        return Mockito.mock(UserRepositoryImpl.class);
    }

    @Bean
    @Primary
    public UserServiceImpl userService(){
        return new UserServiceImpl(userRepository());
    }
}
