package com.example.demo.config;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "pedro", "pedroajs@gmail", "21998536", "93810++001");
        User user2 = new User(null, "maria", "mariadb@gmail", "218966387", "810++001");

        userRepository.saveAll(Arrays.asList(user1,user2));
    }
}
