package com.selfdeveloped.jpa.hibernate_n_plus_1_problem_and_solution;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class Customer3Controller {

    private final Customer3Service service;

    public Customer3Controller(Customer3Service service) {
        this.service = service;
    }

    @PostMapping
    public Customer3 createCustomer(@RequestBody Customer3 customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer3> getCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/fetch_join")
    public List<Customer3> fetchAllCustomersWithAddresses() {
        return service.getAllCustomersWithAddresses();
    }
}