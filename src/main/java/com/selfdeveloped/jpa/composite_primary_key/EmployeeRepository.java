package com.selfdeveloped.jpa.composite_primary_key;

import com.selfdeveloped.jpa.composite_primary_key.IdClass_Demo.Employee;
import com.selfdeveloped.jpa.composite_primary_key.IdClass_Demo.EmployeePKId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeePKId> {
}
