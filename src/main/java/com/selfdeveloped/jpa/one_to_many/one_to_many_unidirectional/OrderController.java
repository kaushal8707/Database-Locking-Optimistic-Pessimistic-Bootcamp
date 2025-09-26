package com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional.dto.*;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    Logger log = LoggerFactory.getLogger(OrderController.class);

    /** One to Many Uni-Directional */
    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest) {
        Customer customer = orderRequest.getCustomer();
        return customerRepository.save(customer);
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

    @GetMapping("/customer/{email}")
    public List<Customer> getCustomerByEmail(@PathVariable String email)
    {
        return customerRepository.getCustomerByEmail(email);
    }

    @GetMapping("/customerByName/{name}")
    public List<Customer> getAllCustomerByNames(@PathVariable String name)
    {
        List<Customer> customerList=customerRepository.getAllCustomerByNames(name);
        log.info("get All Users By Names - {}",customerList);
        return customerList;
    }

    @PutMapping("/update_customer_data/{id}/{email}")
    public String updateCustomerEmail(@PathVariable int id, @PathVariable String email) {
        customerRepository.updateEmail(id,email);
        log.info("New Email for customer-id {} is - {}",id,email);
        return "New Email for customer-id"+id+" is - "+email;
    }

    @PutMapping("/change_customer_data/{id}/{email}")
    public String changeEmail(@PathVariable int id, @PathVariable String email) {
        customerRepository.changeEmail(id,email);
        log.info("New Email for customer-id {} is - {}",id,email);
        return "New Email for customer-id"+id+" is - "+email;
    }
}
