package com.example.backend.controller;

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
    //krijgt verzoek binnen
    @GetMapping("")
    public ResponseEntity<Object> getCar() {
        return ResponseEntity.ok(carService.getCar());
    }
    //create employee rest API
    @PostMapping("")
    public ResponseEntity<Object> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.ok("Added");
    }
    //get 1 employee
    //krijgt verzoek binnen
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCar(@PathVariable("id") long id) {
        Car car = carService.getCar(id);
        return ResponseEntity.ok(car);
    }
    //query to search on firstname (customers/firstname?firstname=David
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable("id") long id, @RequestBody Car updateCar) {
        carService.updateCar(id, updateCar);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCar(@PathVariable("id") long id) {
        carService.removeCar(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}