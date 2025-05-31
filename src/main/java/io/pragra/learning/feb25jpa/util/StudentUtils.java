package io.pragra.learning.feb25jpa.util;

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
}
