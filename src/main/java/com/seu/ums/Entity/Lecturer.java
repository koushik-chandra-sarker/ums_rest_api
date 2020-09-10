package com.seu.ums.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Lecturer implements Serializable {
    @Id
    @GeneratedValue
    private long Id;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Title;
    private LocalDate Birthday;
    private String Gender;
    private LocalDate joiningDate;
    private String officeRoom;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    private List<Phone> phone;
    @ManyToOne
    private School school;

    @ManyToOne
    @JoinColumn
    private Lecturer supervisor;

    @OneToMany(mappedBy = "supervisor",cascade = CascadeType.ALL)
    private List<Lecturer> lecturer = new ArrayList<>();

    @OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL)
    private List<Lecturer_Course> lecturer_courses = new ArrayList<>();


    /*@OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL)
    private List<Course_Student> course_students = new ArrayList<>();*/

    /*

    @OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL)
    private List<Committee_Lecturer> committee_lecturers = new ArrayList<>();


    */
}
