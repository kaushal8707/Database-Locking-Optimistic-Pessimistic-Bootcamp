package com.selfdeveloped.jpa.composite_primary_key.EmbededId_Demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeController2 {

    private final EmployeeRepository2 repository;

    public EmployeeController2(EmployeeRepository2 repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employee2 save(@RequestBody Employee2 employee) {
        return repository.save(employee);
    }

    @GetMapping
    public List<Employee2> getAll() {
        return repository.findAll();
    }
}
