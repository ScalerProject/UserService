package com.scaler.userservicejan25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserServiceJan25Application {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceJan25Application.class, args);
    }
}
