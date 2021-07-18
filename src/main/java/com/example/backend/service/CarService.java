package com.example.backend.service;

import com.example.backend.controller.dto.CarDto;
import com.example.backend.model.Car;
import java.util.List;

public interface CarService {
        List<Car> getCar();
        Car getCar(long id);
        Car addCar(CarDto car);
        void removeCar(long id);
        void updateCar(long id, Car car);
}
