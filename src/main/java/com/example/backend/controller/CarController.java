package com.example.backend.controller;

import com.example.backend.controller.dto.CarDto;
import com.example.backend.model.Car;
import com.example.backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("")
    public ResponseEntity<Object> getCar() {
        return ResponseEntity.ok(carService.getCar());
    }

    @PostMapping("")
    public ResponseEntity<Object> addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCar(@PathVariable("id") long id) {
        Car car = carService.getCar(id);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable("id") long id, @RequestBody Car updateCar) {
        carService.updateCar(id, updateCar);
        return ResponseEntity.noContent().build().ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCar(@PathVariable("id") long id) {
        carService.removeCar(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}