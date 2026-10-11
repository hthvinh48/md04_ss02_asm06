package com.example.userservice.config;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository repo) {
        return args -> {
            if (repo.count() > 0) return;

            for (int i = 1; i <= 25; i++) {
                User u = new User();
                u.setFullName("User " + i);
                u.setEmail("user" + i + "@example.com");
                u.setPasswordHash("hash_demo_" + i);
                repo.save(u);
            }
        };
    }
}