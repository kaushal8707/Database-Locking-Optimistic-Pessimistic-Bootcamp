package com.selfdeveloped.jpa.composite_primary_key.IdClass_Demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EmployeePKId.class)
public class Employee {

    @Id
    private int empId;
    @Id
    private int deptId;
    private String name;
    private String email;
    private String phone;
}
