package com.selfdeveloped.jpa.composite_primary_key.EmbededId_Demo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EmployeePKId2 implements Serializable {

    private int empId;
    private int deptId;
}
