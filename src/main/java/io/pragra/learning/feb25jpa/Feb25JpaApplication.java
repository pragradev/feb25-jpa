package io.pragra.learning.feb25jpa;

import io.pragra.learning.feb25jpa.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Feb25JpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Feb25JpaApplication.class, args);

        StudentService studentService = context.getBean(StudentService.class);
        System.out.println(studentService.getStudents());
    }


}
