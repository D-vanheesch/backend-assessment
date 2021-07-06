package com.example.backend.service;

import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.Customer;
import com.example.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//complexere stukken van je app, zet in je service

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
//    private List<Customer> customers = new ArrayList<>();

    @Override
        public List<Customer> getCustomers() {
         return customerRepository.findAll();
//        return customers;
   }

   @Override
   public Customer getCustomer ( long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("Person does not exist");
        }
////        return null;
//        Customer customer = null;
//        for (int i = 0; i < customers.size(); i++) {
//            if (id == customers.get(i).getId()) {
//                customer = customers.get(i);
//            }
//        }
//        //indien ID niet bestaat, geef foutmelding weer
//        if (customer == null) {
//            throw new RecordNotFoundException("id not found");
//        }
//        return customer;
    }

    @Override
    public Customer addCustomer (Customer customer){
//            customers.add(customer);
            return customerRepository.save(customer);
        }

    @Override
        public void removeCustomer ( long id){
        customerRepository.deleteById(id);
//        Customer customer = null;
//        for (int i=0; i < customers.size(); i++) {
//            if (id == customers.get(i).getId()) {
//                customers.remove(i);
//            }
//        }
//        if (customer == null) {
//            throw new RecordNotFoundException("id not found");
//        }
        }

        @Override
        public void updateCustomer (long id, Customer updateCustomer) {
           Optional<Customer> optionalCustomer = customerRepository.findById(id);
           if (optionalCustomer.isPresent()) {
               customerRepository.save(updateCustomer);
           } else {
               throw new RecordNotFoundException("Person does not exist");
           }
//        Customer customer = null;
//        for (int i = 0; i < customers.size(); i++) {
//            if (id == customers.get(i).getId()) {
//                customer = customers.get(i);
//            }
//        }
//        if (customer == null) {
//            throw new RecordNotFoundException("id not found");
//        } else {
//            customer.setFirstName(updateCustomer.getFirstName());
//            customer.setSecondName(updateCustomer.getSecondName());
//            customer.setResidence(updateCustomer.getResidence());
//            customer.setAge(updateCustomer.getAge());
//            customer.setEmailAdress(updateCustomer.getEmailAdress());
//            customer.setCarPapers(updateCustomer.getCarPapers());
//        }
//
//    }
        }
//query search
    @Override
    public Customer getByFirstName(String firstname) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByFirstName(firstname);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new RecordNotFoundException("Person does not exist");
        }
    }
}