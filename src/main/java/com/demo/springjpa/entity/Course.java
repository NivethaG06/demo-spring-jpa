package com.demo.springjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_gen",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_gen",
            strategy = GenerationType.AUTO)
    private Long courseId;
    private String title;
    private Integer credit;


}
