package com.selfdeveloped.jpa.lazy_eager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loading/strategies")
public class Customer1Controller {
    private final Customer1Repository customer1Repository;

    @Autowired
    public Customer1Controller(Customer1Repository customer1Repository) {
        this.customer1Repository = customer1Repository;
    }

    @PostMapping
    public ResponseEntity<Customer1> create(@RequestBody Customer1 customer1) {
        Customer1 saved = customer1Repository.save(customer1);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        Customer1 customer1 = customer1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
        List<Address1> addresses1 = customer1Repository.findById(id).get().getAddresses1();
//        return ResponseEntity.ok(customer1.getName())
          return ResponseEntity.ok(addresses1);
    }
}