package com.selfdeveloped.jpa.cascade_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loading/strategies")
public class Customer2Controller {
    private final Customer2Repository customer2Repository;

    @Autowired
    public Customer2Controller(Customer2Repository customer2Repository) {
        this.customer2Repository = customer2Repository;
    }

    @PostMapping
    public ResponseEntity<Customer2> create(@RequestBody Customer2 customer2) {
        Customer2 saved = customer2Repository.save(customer2);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        Customer2 customer2 = customer2Repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
        return ResponseEntity.ok(customer2.getName());
    }
}