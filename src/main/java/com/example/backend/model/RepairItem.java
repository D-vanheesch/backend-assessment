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
    private Integer waterPumpPrice;
    private Integer waterPumpSupply;
    private String repairWaterPump;
    private String engine;
    private Integer enginePrice;
    private Integer engineSupply;
    private String repairEngine;
    private String brakeDiscs;
    private Integer brakeDiscsPrice;
    private Integer brakeDiscsSupply;
    private String repairBrakeDiscs;
    private String brakePads;
    private Integer brakePadsPrice;
    private Integer brakePadsSupply;
    private String repairBrakePads;
    private String other;
    private Integer otherPrice;

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

    public Integer getWaterPumpPrice() {
        return waterPumpPrice;
    }

    public void setWaterPumpPrice(Integer waterPumpPrice) {
        this.waterPumpPrice = waterPumpPrice;
    }

    public Integer getWaterPumpSupply() {
        return waterPumpSupply;
    }

    public void setWaterPumpSupply(Integer waterPumpSupply) {
        this.waterPumpSupply = waterPumpSupply;
    }

    public String getRepairWaterPump() {
        return repairWaterPump;
    }

    public void setRepairWaterPump(String repairWaterPump) {
        this.repairWaterPump = repairWaterPump;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getEnginePrice() {
        return enginePrice;
    }

    public void setEnginePrice(Integer enginePrice) {
        this.enginePrice = enginePrice;
    }

    public Integer getEngineSupply() {
        return engineSupply;
    }

    public void setEngineSupply(Integer engineSupply) {
        this.engineSupply = engineSupply;
    }

    public String getRepairEngine() {
        return repairEngine;
    }

    public void setRepairEngine(String repairEngine) {
        this.repairEngine = repairEngine;
    }

    public String getBrakeDiscs() {
        return brakeDiscs;
    }

    public void setBrakeDiscs(String brakeDiscs) {
        this.brakeDiscs = brakeDiscs;
    }

    public Integer getBrakeDiscsPrice() {
        return brakeDiscsPrice;
    }

    public void setBrakeDiscsPrice(Integer brakeDiscsPrice) {
        this.brakeDiscsPrice = brakeDiscsPrice;
    }

    public Integer getBrakeDiscsSupply() {
        return brakeDiscsSupply;
    }

    public void setBrakeDiscsSupply(Integer brakeDiscsSupply) {
        this.brakeDiscsSupply = brakeDiscsSupply;
    }

    public String getRepairBrakeDiscs() {
        return repairBrakeDiscs;
    }

    public void setRepairBrakeDiscs(String repairBrakeDiscs) {
        this.repairBrakeDiscs = repairBrakeDiscs;
    }

    public String getBrakePads() {
        return brakePads;
    }

    public void setBrakePads(String brakePads) {
        this.brakePads = brakePads;
    }

    public Integer getBrakePadsPrice() {
        return brakePadsPrice;
    }

    public void setBrakePadsPrice(Integer brakePadsPrice) {
        this.brakePadsPrice = brakePadsPrice;
    }

    public Integer getBrakePadsSupply() {
        return brakePadsSupply;
    }

    public void setBrakePadsSupply(Integer brakePadsSupply) {
        this.brakePadsSupply = brakePadsSupply;
    }

    public String getRepairBrakePads() {
        return repairBrakePads;
    }

    public void setRepairBrakePads(String repairBrakePads) {
        this.repairBrakePads = repairBrakePads;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(Integer otherPrice) {
        this.otherPrice = otherPrice;
    }

    public RepairJob getRepairJob() {
        return repairJob;
    }

    public void setRepairJob(RepairJob repairJob) {
        this.repairJob = repairJob;
    }
}
