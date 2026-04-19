package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

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
        Order o1 = new Order();
        o1.setMoment(Instant.parse("2019-06-20T19:53:07Z"));
        o1.setClient(u1);
        Order o2 = new Order();
        o2.setMoment(Instant.parse("2019-07-21T03:42:10Z"));
        o2.setClient(u2);
        Order o3 = new Order();
        o3.setMoment(Instant.parse("2019-07-22T15:21:22Z"));
        o3.setClient(u1);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
