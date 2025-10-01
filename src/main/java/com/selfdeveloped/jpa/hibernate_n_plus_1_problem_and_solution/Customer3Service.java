package com.selfdeveloped.jpa.hibernate_n_plus_1_problem_and_solution;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Customer3Service {

    private final Customer3Repository customerRepository;

    public Customer3Service(Customer3Repository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer3 saveCustomer(Customer3 customer3) {
        return customerRepository.save(customer3);
    }

    public Customer3 getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Exception occurred while fetching customer -"+id));
    }

    public List<Customer3> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer3> getAllCustomersWithAddresses() {
        return customerRepository.fetchCustomersWithAddresses();
    }
}
