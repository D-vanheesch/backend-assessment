package com.example.backend.service;
//Business logica rondom customer

import com.example.backend.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();
    Customer getCustomer(long id);
    Customer addCustomer(Customer customer);
    void removeCustomer(long id);
    void updateCustomer(long id, Customer customer);

    //query uitbreiding
    Customer getByFirstName(String firstname);
//    Customer getByPhoneNumber(Integer phoneNumber);

}
