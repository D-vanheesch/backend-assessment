package com.example.backend.model;

//domein klasses

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity
@Table (name = "customer")
@RestController
public class Customer {

    // attributen
    //Column te gebruiken voor custom namen van je tabel
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String secondName;
    private String residence;
    private String emailAdress;
    private Integer phoneNumber;
    private Integer age;

    @OneToOne
    private Car car;

//    public Customer () {
//
//    }
//
////    generate constructer
//    public Customer(String firstName, String secondName, String residence, String emailAdress, Integer age) {
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.residence = residence;
//        this.emailAdress = emailAdress;
//        this.age = age;
//    }

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
