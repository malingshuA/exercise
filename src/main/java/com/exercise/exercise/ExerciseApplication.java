package com.exercise.exercise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@SpringBootApplication
@RequestMapping
@Controller
//@SpringBootApplication(exclude = WebAutoConfiguration.class)
@SpringBootApplication
@MapperScan("com.exercise.exercise.mapper")
public class ExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }

}
