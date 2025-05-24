package io.pragra.learning.feb25jpa.services;

import io.pragra.learning.feb25jpa.entities.Student;
import io.pragra.learning.feb25jpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudents(){
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }


}
