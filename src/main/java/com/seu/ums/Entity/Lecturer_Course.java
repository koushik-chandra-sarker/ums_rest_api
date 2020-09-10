package com.seu.ums.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "lecturer_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ssn")
public class Lecturer_Course{

    @Id
    private String Ssn;

    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn
    private Course course;

    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Course_Student> course_students = new ArrayList<>();


}
