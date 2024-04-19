package org.example.userreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserReviewServiceApplication.class, args);
    }

}
