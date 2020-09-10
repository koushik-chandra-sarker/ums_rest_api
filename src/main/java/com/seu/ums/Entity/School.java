package com.seu.ums.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Name;

    @ManyToOne
    private Campus Campus;
    /*
        @JsonBackReference
        public Campus getCampus() {
            return Campus;
        }*/
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Programme> programme = new ArrayList<>();

    @OneToMany(mappedBy = "school")
    private List<Lecturer> lecturers = new ArrayList<>();

}
