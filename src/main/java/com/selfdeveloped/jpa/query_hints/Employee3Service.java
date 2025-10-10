package com.selfdeveloped.jpa.query_hints;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class Employee3Service {

    @Autowired
    private Employee3Repository repository;

    public Long fetchEmployees(){
        return repository.count();
    }

    public List<Employee3> getEmployeesBySalary(double salary){
        return repository.findEmployeesWithSalaryGreaterThan(salary);
    }

    /** inserted 25k records to check performance for a first time

    @PostConstruct
    public void init(){
        List<Employee3> employeeList = IntStream.rangeClosed(1, 25000)
                .mapToObj(i -> new Employee3("Employee_" + i, "Department_" + i, "Email_" + i, "Male", new Random().nextDouble(75000 - 100) + 100))
                .toList();
        repository.saveAll(employeeList);

    } */

}