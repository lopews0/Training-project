package com.trainingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
public class TrainingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingProjectApplication.class, args);
    }

}
