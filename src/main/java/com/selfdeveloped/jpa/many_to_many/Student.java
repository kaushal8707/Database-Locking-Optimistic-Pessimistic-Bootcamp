package com.selfdeveloped.jpa.many_to_many;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    private String name;
    private int age;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
    joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "sid")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "cid")
    })

    private Set<Course> courses;
}
