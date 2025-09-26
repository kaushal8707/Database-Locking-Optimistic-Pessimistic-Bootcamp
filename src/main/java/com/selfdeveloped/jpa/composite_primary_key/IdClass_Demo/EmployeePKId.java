package com.selfdeveloped.jpa.composite_primary_key.IdClass_Demo;

import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeePKId implements Serializable {

    private int empId;
    private int deptId;
}
