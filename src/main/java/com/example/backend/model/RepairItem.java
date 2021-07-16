package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class RepairItem {

    @Id
    @GeneratedValue
    private Long id;

    private String waterPump;
    private Double waterPumpPrice;
    private int waterPumpSupply;
    private String brakeDiscs;
    private Double brakeDiscsPrice;
    private int brakeDiscsSupply;
    private String brakePads;
    private Double brakePadsPrice;
    private int brakePadsSupply;
    private String other;
    private Double otherPrice;

    @ManyToOne()
    @JsonBackReference
    private RepairJob repairJob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWaterPump() {
        return waterPump;
    }

    public void setWaterPump(String waterPump) {
        this.waterPump = waterPump;
    }

    public Double getWaterPumpPrice() {
        return waterPumpPrice;
    }

    public void setWaterPumpPrice(Double waterPumpPrice) {
        this.waterPumpPrice = waterPumpPrice;
    }

    public int getWaterPumpSupply() {
        return waterPumpSupply;
    }

    public void setWaterPumpSupply(int waterPumpSupply) {
        this.waterPumpSupply = waterPumpSupply;
    }

    public String getBrakeDiscs() {
        return brakeDiscs;
    }

    public void setBrakeDiscs(String brakeDiscs) {
        this.brakeDiscs = brakeDiscs;
    }

    public Double getBrakeDiscsPrice() {
        return brakeDiscsPrice;
    }

    public void setBrakeDiscsPrice(Double brakeDiscsPrice) {
        this.brakeDiscsPrice = brakeDiscsPrice;
    }

    public int getBrakeDiscsSupply() {
        return brakeDiscsSupply;
    }

    public void setBrakeDiscsSupply(int brakeDiscsSupply) {
        this.brakeDiscsSupply = brakeDiscsSupply;
    }

    public String getBrakePads() {
        return brakePads;
    }

    public void setBrakePads(String brakePads) {
        this.brakePads = brakePads;
    }

    public double getBrakePadsPrice() {
        return brakePadsPrice;
    }

    public void setBrakePadsPrice(double brakePadsPrice) {
        this.brakePadsPrice = brakePadsPrice;
    }

    public int getBrakePadsSupply() {
        return brakePadsSupply;
    }

    public void setBrakePadsSupply(int brakePadsSupply) {
        this.brakePadsSupply = brakePadsSupply;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Double getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(Double otherPrice) {
        this.otherPrice = otherPrice;
    }

    public RepairJob getRepairJob() {
        return repairJob;
    }

    public void setRepairJob(RepairJob repairJob) {
        this.repairJob = repairJob;
    }
}
