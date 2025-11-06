package com.example.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigDI {

    @Bean
    public Course course() {
        return new Course();
    }

    @Bean
    public StudentDI studentDI() {
        return new StudentDI(course());
    }
}
