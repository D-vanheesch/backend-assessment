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

    /**
     * Map getCar to get car information
     *
     * @return ok || badRequest
     */
    @GetMapping("")
    public ResponseEntity<Object> getCar() {
        if (carService.getCar() != null) {
            return ResponseEntity.ok(carService.getCar());
        } else {
           return ResponseEntity.badRequest().body("No information found.");
        }
    }

    /**
     * Map addCar to insert a new car with attributes
     *
     * @return ok
     */
    @PostMapping("")
    public ResponseEntity<Object> addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
        return ResponseEntity.ok("Added");
    }

    /**
     * Map getCar to get information by carId
     *
     * @param id carId to get information for
     *
     * @return ok || badRequest
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCar(@PathVariable("id") long id) {
        if (carService.getCar() != null) {
            Car car = carService.getCar(id);
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.badRequest().body("No information found.");
        }
    }

    /**
     * Map updateCar to change car information
     *
     * @param id defined car id
     * @param updateCar updated information
     *
     * @return ok
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable("id") long id, @RequestBody Car updateCar) {
        carService.updateCar(id, updateCar);
        return ResponseEntity.noContent().build().ok("Updated");
    }

    /**
     * Map removeCar to remove car by car id
     *
     * @param id defined car id
     *
     * @return ok
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCar(@PathVariable("id") long id) {
        carService.removeCar(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}