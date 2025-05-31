package io.pragra.learning.feb25jpa.api;

import io.pragra.learning.feb25jpa.entities.Student;
import io.pragra.learning.feb25jpa.services.StudentService;
import jdk.jfr.ContentType;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
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
// HTTP:GET http://localhost:8080/student/getAll
    //@RequestMapping(method = RequestMethod.GET,path = "/getAll")
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getStudents();
        return students;
    }

    @GetMapping("/byId")
    public Optional<Student> getById(@RequestParam("id") Integer identification){
        Optional<Student> studentById = studentService.getStudentById(identification);

        return studentById;
    }
    @GetMapping("/byId/{id}")
    public Optional<Student> getByIdInPath(@PathVariable("id") Integer id){
        Optional<Student> studentById = studentService.getStudentById(id);

        return studentById;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
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






}
