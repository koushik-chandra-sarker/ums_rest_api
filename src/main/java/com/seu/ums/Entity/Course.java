package com.seu.ums.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "code")
public class Course implements Serializable {
    @Id
    private String Code;
    private String title;
    private int credit;

    @ManyToOne
    private Programme programme;

    @ManyToMany
    @JoinTable(
            name = "pre_course",
            joinColumns = @JoinColumn(name = "course_code"),
            inverseJoinColumns = @JoinColumn(name = "pre_course_code")
    )
    private List<Course> pre_course;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "pre_course",
            joinColumns = @JoinColumn(name = "pre_course_code"),
    inverseJoinColumns = @JoinColumn(name = "course_code")
    )
    private List<Course> courses;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Lecturer_Course> lecturer_courses = new ArrayList<>();




}
