package com.selfdeveloped.jpa.cascade_type;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cascade/behavior")
@Transactional
public class Customer2Controller {
    private final Customer2Repository customer2Repository;

    @PersistenceContext
    private EntityManager entityManager;

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

    @GetMapping("/refresh/{id}")
    public String getRefresh(@PathVariable Long id) {
        return testRefresh(id);
    }

    @GetMapping("/detach/{id}")
    public String getDetach(@PathVariable Long id) {
        return testDetach(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer2> updateProduct(@RequestBody Customer2 customer2) {
        Customer2 existingCustomer=customer2Repository.findById(customer2.getId()).orElse(null);
        existingCustomer.setName(customer2.getName());
        existingCustomer.getAddresses2().stream().filter(adr->adr.getId()== customer2.getAddresses2().get(0).getId())
                .forEach(adr-> adr.setZipCode(customer2.getAddresses2().get(0).getZipCode()));
         return new ResponseEntity(customer2Repository.save(existingCustomer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        customer2Repository.deleteById(id);
        return "product remove || "+id;
    }

    public String testRefresh(Long customerId) {
        Customer2 customer2 = entityManager.find(Customer2.class, customerId);
        System.out.println("Original City from DB "+customer2.getAddresses2().get(0).getCity());

        //change address city in memory
        customer2.getAddresses2().get(0).setCity("New City");
        System.out.println("In Memory change "+customer2.getAddresses2().get(0).getCity());

        //refresh only customer
        entityManager.refresh(customer2);

        System.out.println("After refresh "+customer2.getAddresses2().get(0).getCity());
        return "refreshed successfully";
    }

    public String testDetach(Long customerId) {
        Customer2 customer2 = entityManager.find(Customer2.class, customerId);
        Address2 address2 = customer2.getAddresses2().get(0);

        System.out.println("Before Detach");
        System.out.println("Customer managed? "+entityManager.contains(customer2)); // true
        System.out.println("Address managed? "+entityManager.contains(address2)); // true

        //Detach the customer(will also detach child only if cascade DETACHED is used)
        entityManager.detach(customer2);

        System.out.println("After Detach");
        System.out.println("Customer managed? "+entityManager.contains(customer2)); // false
        System.out.println("Address managed? "+entityManager.contains(address2)); // depends on cascade type
        return "detaching successfully";
    }
}