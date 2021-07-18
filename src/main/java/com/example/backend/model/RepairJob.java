package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
    private String repairStatus;

    @OneToOne
    @Cascade(CascadeType.ALL)
    @JsonManagedReference
    //gaat de loop tegen om van customer nog een Json te maken.
    private Customer customer;

    @OneToMany(mappedBy = "repairJob")
    @JsonManagedReference
    private List<RepairItem> repairItem;

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

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<RepairItem> getRepairItem() {
        return repairItem;
    }

    public void setRepairItem(List<RepairItem> repairItem) {
        this.repairItem = repairItem;
    }
}
