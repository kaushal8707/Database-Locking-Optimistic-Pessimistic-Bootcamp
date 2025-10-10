package com.selfdeveloped.jpa.query_hints;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dept;
    private String email;
    private String gender;
    private double salary;

    public Employee3(String name, String dept, String email, String gender, double salary) {
        this.name = name;
        this.dept = dept;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }
}
