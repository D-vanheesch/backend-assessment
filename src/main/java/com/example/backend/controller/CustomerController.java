package com.example.backend.controller;

import com.example.backend.model.Customer;
import com.example.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController  {

    @Autowired
    private CustomerService customerService;

    /**
     * Map getCustomers to get all customers
     *
     * @return ok || badRequest
     */
    @GetMapping("")
    public ResponseEntity<Object> getCustomers() {
        if (customerService.getCustomers() != null) {
            return ResponseEntity.ok(customerService.getCustomers());
        } else {
            return ResponseEntity.badRequest().body("No information found.");
        }
    }

    /**
     * Map addCustomer add new customer with attributes
     *
     * @param customer customer information to attach
     *
     * @return ok
     */
    @PostMapping("")
    public ResponseEntity<Object> addCustomer (@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Added");
    }

    /**
     * Map getCustomer get customer information by id
     *
     * @param id id from the customer
     *
     * @return ok || badRequest
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomers(@PathVariable("id") long id) {
        if (customerService.getCustomers() != null) {
            Customer customer = customerService.getCustomer(id);
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.badRequest().body("No information found.");
        }
    }

    /**
     * Map getCustomer get customer information by first name
     *
     * @param firstname firstname from customer
     *
     * @return ok
     */
    @GetMapping("/firstname")
    public Customer getCustomer(@RequestParam String firstname) {
        return customerService.getByFirstName(firstname);
    }

    /**
     * Map updateCustomer update customer information
     *
     * @param id customer id to update information
     * @param updateCustomer new information to update on a customer
     *
     * @return ok
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer updateCustomer) {
        customerService.updateCustomer(id, updateCustomer);
        return ResponseEntity.noContent().build();
    }

    /**
     * Map removeCustomer remove customer information
     *
     * @param id customer id to remove customer
     *
     * @return ok
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCustomer(@PathVariable("id") long id) {
        customerService.removeCustomer(id);
            return ResponseEntity.noContent().build().ok("Deleted");
        }
    }




