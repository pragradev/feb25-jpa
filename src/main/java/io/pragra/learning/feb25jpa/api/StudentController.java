package io.pragra.learning.feb25jpa.api;

import io.pragra.learning.feb25jpa.dto.StudentDTO;
import io.pragra.learning.feb25jpa.dto.StudentTo;
import io.pragra.learning.feb25jpa.entities.Phone;
import io.pragra.learning.feb25jpa.entities.Student;
import io.pragra.learning.feb25jpa.services.StudentService;
import io.pragra.learning.feb25jpa.util.StudentUtils;
import jdk.jfr.ContentType;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller // mvc - data
//@ResponseBody
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentUtils studentUtils;
// HTTP:GET http://localhost:8080/student/getAll
    //@RequestMapping(method = RequestMethod.GET,path = "/getAll")
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Student> students = studentService.getStudents();
        return students;
    }

    @GetMapping("/byId")
    public StudentTo getById(@RequestParam("id") Integer identification){
        Optional<Student> optionalStudent = studentService.getStudentById(identification);
        StudentTo studentTo = new StudentTo();
        if(optionalStudent.isPresent()){
            studentUtils.converterStudentEntitytoTO(studentTo,optionalStudent.get());
        }
        return studentTo;
    }
    @GetMapping("/byId/{id}")
    public StudentTo getByIdInPath(@PathVariable("id") Integer id){
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        StudentTo studentTo = new StudentTo();
        if(optionalStudent.isPresent()){
            studentUtils.converterStudentEntitytoTO(studentTo,optionalStudent.get());
        }
        return studentTo;
    }
    @GetMapping("/getPhone/{id}")
    public Phone getPhoneIdInPath(@PathVariable("id") Integer id){
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        Phone phone = null;
        if(optionalStudent.isPresent()){
            phone = optionalStudent.get().getPhone();
        }
        return phone;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentEntity = studentService.createStudent(student);
        ResponseEntity<Student> studentResponseEntity = ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .header("Action", "Created")
                .header("GenId", String.valueOf(studentEntity.getId()))
                .header("status", String.valueOf(1100))
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentEntity);
        return studentResponseEntity;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @PatchMapping("/patch")
    public Student patch(@RequestBody Student student){
        return studentService.patchUpdate(student);
    }

    @GetMapping("/allByName")
    public List<Student> getAllByFirstName(@RequestParam String name){
        return studentService.getAllByFirstName(name);
    }

    @PostMapping("/lastnames")
        public List<String> getAllLastNames(@RequestBody StudentDTO studentDTO){
        return studentService.getLastNames(studentDTO.getFirstName());
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }





}
