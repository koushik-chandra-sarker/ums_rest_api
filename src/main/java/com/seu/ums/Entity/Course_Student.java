package com.seu.ums.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "course_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ssn")
public class Course_Student implements Serializable {

    @Id
    private String Ssn;

    @ManyToOne
    @JoinColumn
    private Student student;


    @ManyToOne
    @JoinColumn
    private Lecturer_Course courses;


    private String yearTaken;
    private String semesterTaken;
    private String gradeAward;




}
