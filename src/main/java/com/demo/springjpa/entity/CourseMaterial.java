package com.demo.springjpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "coursematerial_gen",
            sequenceName = "coursematerial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "coursematerial_gen"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.EAGER // fetch both coursematerial and course
//            fetch = FetchType.LAZY //will only fetch the cousematerial
    )
    @JoinColumn(
            name = "course_id", //name of teh column
            referencedColumnName = "courseId"
    )
    private Course course;
}
