package com.example.backend.service;

import com.example.backend.controller.dto.CarDto;
import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.Car;
import com.example.backend.model.Customer;
import com.example.backend.repository.CarRepository;
import com.example.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Define car repository with customer repository
     *
     * @param customerRepository to add customer repository to car repository
     */
    @Autowired
    public CarServiceImpl(CarRepository customerRepository) {
        this.carRepository = customerRepository;
    }

    /**
     * Get all cars
     *
     * @return carRepository.findAll()
     */
    @Override
    public List<Car> getCar() {
        return carRepository.findAll();
    }


    /**
     * Get car by id
     *
     * @param id find car repository by id
     *
     * @return car.get()
     * @throws RecordNotFoundException No record available
     */
    @Override
    public Car getCar ( long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return car.get();
        } else {
            throw new RecordNotFoundException("Car does not exist");
        }
    }

    /**
     * Add new car with attributes
     *
     * @param carInformation car information
     *
     * @return carRepository.save()
     */
    @Override
    public Car addCar (CarDto carInformation){
        Car car = new Car();
        car.setLicensePlate(carInformation.getLicensePlate());
        car.setDayOfCarCheck(carInformation.getDayOfCarCheck());
        car.setDayOfRepairJob(carInformation.getDayOfRepairJob());
        Customer customer = customerRepository.findById(carInformation.getCustomerId()).orElse(null);
        car.setCustomer(customer);
        return carRepository.save(car);
    }

    /**
     * Remove car by id
     *
     * @param id car id to remove
     */
    @Override
    public void removeCar ( long id){
        carRepository.deleteById(id);
    }

    /**
     * Update car by id
     *
     * @param id car id to find
     * @param updateCar new car information
     *
     * @throws RecordNotFoundException()
     */
    @Override
    public void updateCar(long id, Car updateCar) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            carRepository.save(updateCar);
        } else {
            throw new RecordNotFoundException("Car does not exist");
        }
    }
}


