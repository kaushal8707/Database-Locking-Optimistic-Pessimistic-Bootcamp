package com.selfdeveloped.jpa.many_to_many;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private Long cid;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;
    @ManyToMany(mappedBy = "courses", fetch =  FetchType.LAZY)
    private Set<Student> students;
}
