package com.selfdeveloped.jpa.composite_primary_key.EmbededId_Demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository2 extends JpaRepository<Employee2, EmployeePKId2> {
}
