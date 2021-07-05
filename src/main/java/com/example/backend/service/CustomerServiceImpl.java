package com.example.backend.service;

import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customers = new ArrayList<>();


    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomer(long id) {
//        return null;
        Customer customer = null;
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customer = customers.get(i);
            }
        }
        //indien ID niet bestaat, geef foutmelding weer
        if (customer == null) {
            throw new RecordNotFoundException("id not found");
        }
        return customer;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public void removeCustomer(long id) {
        Customer customer = null;
        for (int i=0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.remove(i);
            }
        }
        if (customer == null) {
            throw new RecordNotFoundException("id not found");
        }
    }

    @Override
    public void updateCustomer(long id, Customer updateCustomer) {
        Customer customer = null;
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customer = customers.get(i);
            }
        }
        if (customer == null) {
            throw new RecordNotFoundException("id not found");
        } else {
            customer.setFirstName(updateCustomer.getFirstName());
            customer.setSecondName(updateCustomer.getSecondName());
            customer.setResidence(updateCustomer.getResidence());
            customer.setAge(updateCustomer.getAge());
            customer.setEmailAdress(updateCustomer.getEmailAdress());
            customer.setCarPapers(updateCustomer.getCarPapers());
        }

    }
}
