package com.example.backend.service;

import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.Car;
import com.example.backend.model.Customer;
import com.example.backend.repository.CarRepository;
import com.example.backend.repository.CustomerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//complexere stukken van je app, zet in je service

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CarRepository carRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CarRepository carRepository) {
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;

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
               throw new RecordNotFoundException("Person does not exist");
           }
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

    //koppeling car met customer??
//   @Override
//    public Customer findByCarId (String id) {
//        return customerRepository.findByCarId(id);
//    }

//    @Override
//    public Customer setCustomerCar(String customerId, String carId) {
//        var customer = customerRepository.findCustomerById(customerId);
//        var car = carRepository.findCarById(carId);
//
//        if (customer.isPresent() && car.isPresent()) {
//            customer.get().setCar(car.get());
//            return customerRepository.save(customer.get());
//        } else {
//           throw new NotFoundException("Customer does not exist");
//        }
//    }
}