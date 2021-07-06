package com.example.backend.repository;


import com.example.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //query search
    Optional<Customer> findCustomerByFirstName(String firstname);
}
