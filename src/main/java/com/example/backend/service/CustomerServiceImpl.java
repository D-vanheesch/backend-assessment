package com.example.backend.service;

import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.Customer;
import com.example.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
        public List<Customer> getCustomers() {
         return customerRepository.findAll();
   }

   @Override
   public Customer getCustomer ( long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }

    @Override
    public Customer addCustomer (Customer customer){
            return customerRepository.save(customer);
        }

    @Override
        public void removeCustomer ( long id){
        customerRepository.deleteById(id);
        }

        @Override
        public void updateCustomer (long id, Customer updateCustomer) {
           Optional<Customer> optionalCustomer = customerRepository.findById(id);
           if (optionalCustomer.isPresent()) {
               customerRepository.save(updateCustomer);
           } else {
               throw new RecordNotFoundException("Customer does not exist");
           }
        }

    @Override
    public Customer getByFirstName(String firstname) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByFirstName(firstname);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }

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