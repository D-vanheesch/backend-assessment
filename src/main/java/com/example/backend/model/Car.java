package com.example.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "car")
public class Car {

    @Id
    @GeneratedValue
    private long id;
    private String licensePlate;
    private String brand;
    private Integer carCustomerId;

    public Car () {
        System.out.println(carCustomerId);
        System.out.println("test");
    }

    public Car(String licensePlate, String brand, Integer carCustomerId) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.carCustomerId = carCustomerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCarCustomerId() {
        System.out.println(carCustomerId);
            return carCustomerId;
    }

    public void setCarCustomerId(Integer carCustomerId) {
        this.carCustomerId = carCustomerId;
    }
}
