package com.example.backend.repository;

import com.example.backend.model.RepairJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairJobRepository extends JpaRepository<RepairJob, Long> {

    List<RepairJob> findRepairJobsByRepairStatus(String repairStatus);

    List<RepairJob> findRepairJobsByCustomerAgrees(String customerAgrees);
}
