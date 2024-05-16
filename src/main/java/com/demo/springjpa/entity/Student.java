package com.demo.springjpa.entity;

import com.demo.springjpa.embedded.Guardian;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Student_test",
        uniqueConstraints = @UniqueConstraint(
                name = "student_unique",
                columnNames = {"email_address","firstName"}
))
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence" ,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "student_sequence"
    )
    //WHY TABLE IS USED
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
