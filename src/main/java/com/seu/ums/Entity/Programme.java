package com.seu.ums.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "code")
public class Programme {

    @Id
    private String Code;
    private String Title;
    private String Label;
    private int Length;

    @ManyToOne
    private School school;

    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "programme_code", referencedColumnName = "code")
    private List<Course> courses = new ArrayList<>();

    /*@OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    private List<Committee_Lecturer> committee_lecturers = new ArrayList<>();*/


}
