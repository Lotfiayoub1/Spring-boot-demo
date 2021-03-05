package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.AUGUST;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    LocalDate.of(2000, AUGUST, 5),
                    "Mariam@gmail.com"
            );

            Student alex = new Student(
                    "alex",
                    LocalDate.of(2014, AUGUST, 5),
                    "Alex@gmail.com"
            );

            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
