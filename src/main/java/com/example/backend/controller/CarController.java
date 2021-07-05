package com.example.backend.controller;

import com.example.backend.model.Car;
import com.example.backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CarController  {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/car")
    public List<Car> getAllCars() {
//        for (int i = 0; i < carRepository.findAll().size(); i++) {
//            System.out.println(carRepository.findAll().get(i).getClass().getSimpleName());
//        }
        return carRepository.findAll();
    }

//    @GetMapping("/car/{id}")
//    public Optional<Car> findOne(@PathVariable Long id) {
//        return carRepository.findAll().get;
//    }

    //create employee rest API
    @PostMapping("car")
    public Car createCar (@RequestBody Car car) {
        return carRepository.save(car);
    }
}
