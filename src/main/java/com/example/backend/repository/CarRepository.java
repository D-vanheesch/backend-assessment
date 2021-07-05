package com.example.backend.repository;

import com.example.backend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    //Collection<Car> findAllBy(String title);
}
