package com.example.backend.model;

//domein klasses

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity
@Table (name = "customers")
@RestController
public class Customer {

    // attributen
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String secondName;
    private String residence;
    private String emailAdress;
    private String carPapers;
    private Integer age;

    public Customer () {

    }

    //generate constructer
    public Customer(String firstName, String secondName, String residence, String emailAdress, String carPapers, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.residence = residence;
        this.emailAdress = emailAdress;
        this.carPapers = carPapers;
        this.age = age;
    }

    // setters en getters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String livingArea) {
        this.residence = livingArea;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getCarPapers() {
        return carPapers;
    }

    public void setCarPapers(String carPapers) {
        this.carPapers = carPapers;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
