package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.*;

@Entity
@Table (name = "customers")
@RestController
public class Customer {

    // attributen
    //Column te gebruiken voor custom namen van je tabel
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String residence;
    private String emailAdress;
    private Integer phoneNumber;
    private Integer age;

    @OneToOne
    @Cascade(CascadeType.ALL)
    //gaat de loop tegen om van customer nog een Json te maken.
    @JsonManagedReference
    private Car car;


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
        return lastName;
    }

    public void setSecondName(String secondName) {
        this.lastName = secondName;
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
