package com.example.backend.service;

import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.Customer;
import com.example.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//logica van code middels getters and setters. get, add, remove, update.
//Connecten met controller laag voor Postman.

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    /**
     * Define customer repository with customer repository
     *
     * @param customerRepository object to define customer repository
     */
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Get all customers
     *
     * @return customerRepository.findAll()
     */
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Get customer by id
     *
     * @param id customer id to find
     * @return customer.get()
     * @throws RecordNotFoundException No record available
     */
    @Override
    public Customer getCustomer(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }

    /**
     * Add new customer
     *
     * @param customer customer information
     * @return customerRepository.save()
     */
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Remove customer by id
     *
     * @param id customer id to remove
     */
    @Override
    public void removeCustomer(long id) {
        customerRepository.deleteById(id);
    }

    /**
     * Update customer by id
     *
     * @param id customer id to update
     * @param updateCustomer new customer information
     * @throws RecordNotFoundException()
     */
    @Override
    public void updateCustomer(long id, Customer updateCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.save(updateCustomer);
        } else {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }

    /**
     * Get customer by first name
     *
     * @param firstname firstname of the customer
     * @return optionalCustomer.get()
     * @throws RecordNotFoundException()
     */
    @Override
    public Customer getByFirstName(String firstname) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByFirstName(firstname);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }

    /**
     * Get customer by phone number
     *
     * @param phoneNumber phonenumber of the customer
     * @return optionalCustomer.get()
     * @throws RecordNotFoundException()
     */
    @Override
    public Customer getByPhoneNumber(Integer phoneNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByPhoneNumber(phoneNumber);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new RecordNotFoundException("Phonenumber does not excist");
        }
    }
}