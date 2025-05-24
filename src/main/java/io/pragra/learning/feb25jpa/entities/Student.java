package io.pragra.learning.feb25jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STU")
public class Student {
    @Id
    private Integer id;
    @Column(length = 50, nullable = true, name = "NAME")
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
