package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.jspecify.annotations.NonNull;
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
    public void run(String @NonNull ... args) {
        User u1 = new User();
        u1.setName("Maria Brown");
        u1.setEmail("maria@gmail.com");
        u1.setPhone("988888888");
        u1.setPassword("123456");
        User u2 = new User();
        u2.setName("Alex Green");
        u2.setEmail("alex@gmail.com");
        u2.setPhone("977777777");
        u2.setPassword("123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
