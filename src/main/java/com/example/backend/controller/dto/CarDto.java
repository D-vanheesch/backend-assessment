package com.example.backend.controller.dto;

public class CarDto {
    private long customerId;
    private String licensePlate;
    private String dayOfCarCheck;
    private String dayOfRepairJob;

    /**
     * Get customer ID for customer
     *
     * @return customerID, ID attached to customer
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
    * Set customer ID based on getCustomerId()
    *
    * @param customerId Known ID of customer
    */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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
}
