package com.example.backend.controller.dto;

import com.example.backend.model.Customer;

public class CustomerDto {
    public String phoneNumber;
    public String firstName;
    public String lastName;

    public static CustomerDto fromCustomer(Customer customer) {
        if (customer == null) return null;
        var dto = new CustomerDto();
        dto.firstName = customer.getFirstName();
        dto.lastName = customer.getLastName();
        dto.phoneNumber = customer.getPhoneNumber();

        return dto;
    }
}
