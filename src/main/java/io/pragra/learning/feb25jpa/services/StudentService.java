package io.pragra.learning.feb25jpa.services;

import io.pragra.learning.feb25jpa.entities.Student;
import io.pragra.learning.feb25jpa.repo.StudentRepo;
import io.pragra.learning.feb25jpa.util.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    StudentUtils studentUtils;

    public List<Student> getStudents(){
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    public Optional<Student> getStudentById(Integer id){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        return optionalStudent;
    }

    public Student createStudent(Student student){
        Student studentEntity = studentRepo.save(student);
        return studentEntity;
    }

    public Student updateStudent(Student student){
        Optional<Student> optionalStudent = studentRepo.findById(student.getId());
        if (optionalStudent.isPresent()){
            return studentRepo.save(student);
        }
        return student;
    }

    public Student patchUpdate(Student dto){
        Optional<Student> optionalStudent = studentRepo.findById(dto.getId());
        Student entity = null;
        if (!optionalStudent.isPresent()) {
            return null;
        }
        entity = optionalStudent.get();
        studentUtils.convertPatchDto(dto,entity);

        return studentRepo.save(entity);
    }

    public List<Student> getAllByFirstName(String firstName){
        List<Student> allByFirstName = studentRepo.findAllByFirstName(firstName);
        return allByFirstName;
    }

    public List<String> getLastNames(String name){
        return studentRepo.findAllLastNamesByFirstName(name);
    }


}
