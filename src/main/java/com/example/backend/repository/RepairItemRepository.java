package com.example.backend.repository;


import com.example.backend.model.RepairItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepairItemRepository extends JpaRepository<RepairItem, Long> {
}
