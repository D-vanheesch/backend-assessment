package com.example.backend.service;

import com.example.backend.model.Car;
import com.example.backend.model.Customer;

import java.util.List;

public interface CarService {
        List<Car> getCar();
        Car getCar(long id);
        Car addCar(Car car);
        void removeCar(long id);
        void updateCar(long id, Car car);
}
