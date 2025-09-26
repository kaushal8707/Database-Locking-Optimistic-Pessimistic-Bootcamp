package com.selfdeveloped.jpa.composite_primary_key.EmbededId_Demo;

import jakarta.persistence.EmbeddedId;
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
public class Employee2 {

    @EmbeddedId
    private EmployeePKId2 pkId2;
    private String name;
    private String email;
    private String phone;
}
