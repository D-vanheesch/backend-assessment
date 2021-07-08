package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private long id;

    private String licensePlate;
    private String dayOfCarCheck;
    private String dayOfRepairJob;

    @OneToOne(mappedBy = "car")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "car")
    private List<RepairJob> repairJobs;

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

    public String getDayOfCarCheck() {
        return dayOfCarCheck;
    }

    public void setDayOfCarCheck(String dayOfCarCheck) {
        this.dayOfCarCheck = dayOfCarCheck;
    }

    public String getDayOfRepairJob() {
        return dayOfRepairJob;
    }

    public void setDayOfRepairJob(String dayOfRepairJob) {
        this.dayOfRepairJob = dayOfRepairJob;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<RepairJob> getRepairJobs() {
        return repairJobs;
    }

    public void setRepairJobs(List<RepairJob> repairJobs) {
        this.repairJobs = repairJobs;
    }
}
