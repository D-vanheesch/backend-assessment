package com.example.backend.controller;

import com.example.backend.model.Customer;
import com.example.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController  {

    @Autowired
    private CustomerService customerService;

    //krijgt verzoek binnen
    @GetMapping("")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    //create employee rest API
    @PostMapping("")
    public ResponseEntity<Object> addCustomer (@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Added");
    }

    //get 1 employee
    //krijgt verzoek binnen
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomers(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomer(id);
            return ResponseEntity.ok(customer);
    }
//query to search on firstname (customers/firstname?firstname=David
    @GetMapping("/firstname")
    public Customer getCustomer(@RequestParam String firstname) {
        return customerService.getByFirstName(firstname);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer updateCustomer) {
        customerService.updateCustomer(id, updateCustomer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCustomer(@PathVariable("id") long id) {
        customerService.removeCustomer(id);
            return ResponseEntity.noContent().build();
        }
    }




