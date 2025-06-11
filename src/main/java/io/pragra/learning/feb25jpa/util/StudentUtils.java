package io.pragra.learning.feb25jpa.util;

import io.pragra.learning.feb25jpa.dto.StudentTo;
import io.pragra.learning.feb25jpa.entities.Student;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentUtils {
    public void convertPatchDto(Student dto, Student entity){
        if (Objects.nonNull(dto.getFirstName()))
            entity.setFirstName(dto.getFirstName());
        if (Objects.nonNull(dto.getLastName()))
            entity.setLastName(dto.getLastName());
        if (Objects.nonNull(dto.getPhoneNumber()))
            entity.setPhoneNumber(dto.getPhoneNumber());
        if (Objects.nonNull(dto.getEmail()))
            entity.setEmail(dto.getEmail());
    }

    public void converterStudentEntitytoTO(StudentTo studentTo, Student entity){
        if (Objects.nonNull(entity.getFirstName()))
            studentTo.setFirstName(entity.getFirstName());
        if (Objects.nonNull(entity.getLastName()))
            studentTo.setLastName(entity.getLastName());
        if (Objects.nonNull(entity.getPhoneNumber()))
            studentTo.setPhoneNumber(entity.getPhoneNumber());
        if (Objects.nonNull(entity.getEmail()))
            studentTo.setEmail(entity.getEmail());
//        if(Objects.nonNull(entity.getCourses()))
//            studentTo.setCourses(entity.getCourses());
//        if (Objects.nonNull(entity.getPhone()))
//            studentTo.setPhone(entity.getPhone());
    }
}
