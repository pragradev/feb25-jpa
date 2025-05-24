package io.pragra.learning.feb25jpa.runner;

import io.pragra.learning.feb25jpa.entities.Student;
import io.pragra.learning.feb25jpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentDataLoader implements CommandLineRunner {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public void run(String... args) throws Exception {
        Student student = new Student();
        student.setId(4);
        student.setFirstName("Ankita");
        student.setLastName("P");
        student.setEmail("ankita@gmail.com");
        student.setPhoneNumber("44557788");

        studentRepo.save(student);


    }
}
