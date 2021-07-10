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
    private String exhaustPipe;
    private String brakePads;
    private String brakeDiscs;
    private String engineFailure;
    private String smallTurn;
    private String bigTurn;
    private String apkInspection;
    private String other;

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

    public String getExhaustPipe() {
        return exhaustPipe;
    }

    public void setExhaustPipe(String exhaustPipe) {
        this.exhaustPipe = exhaustPipe;
    }

    public String getBrakePads() {
        return brakePads;
    }

    public void setBrakePads(String brakePads) {
        this.brakePads = brakePads;
    }

    public String getBrakeDiscs() {
        return brakeDiscs;
    }

    public void setBrakeDiscs(String brakeDiscs) {
        this.brakeDiscs = brakeDiscs;
    }

    public String getEngineFailure() {
        return engineFailure;
    }

    public void setEngineFailure(String engineFailure) {
        this.engineFailure = engineFailure;
    }

    public String getSmallTurn() {
        return smallTurn;
    }

    public void setSmallTurn(String smallTurn) {
        this.smallTurn = smallTurn;
    }

    public String getBigTurn() {
        return bigTurn;
    }

    public void setBigTurn(String bigTurn) {
        this.bigTurn = bigTurn;
    }

    public String getApkInspection() {
        return apkInspection;
    }

    public void setApkInspection(String apkInspection) {
        this.apkInspection = apkInspection;
    }

    public RepairJob getRepairJob() {
        return repairJob;
    }

    public void setRepairJob(RepairJob repairJob) {
        this.repairJob = repairJob;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
