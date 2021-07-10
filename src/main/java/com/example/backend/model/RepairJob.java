package com.example.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class RepairJob {

    @Id
    @GeneratedValue
    private Long id;

    private String examination;
    private String customerAgrees;
    private String actions;

    @ManyToOne
    private Car car;

    @OneToMany(mappedBy = "repairJob")
    private List<RepairItem> repairItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public List<RepairItem> getRepairItems() {
        return repairItems;
    }

    public void setRepairItems(List<RepairItem> repairItems) {
        this.repairItems = repairItems;
    }
}
