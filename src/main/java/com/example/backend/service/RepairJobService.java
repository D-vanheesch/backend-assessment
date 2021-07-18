package com.example.backend.service;

import com.example.backend.controller.dto.RepairJobDto;
import com.example.backend.model.RepairJob;

import java.util.List;

public interface RepairJobService {
    List<RepairJob> getRepairJob();
    RepairJob getRepairJob(long id);
    RepairJob addRepairJob(RepairJobDto repairJobDto);
    void removeRepairJob(long id);
    void updateRepairJob(long id, RepairJob repairJob);
    List<RepairJob> getByCustomerAgrees(String customerAgrees);
    List<RepairJob> getByRepairStatus(String repairStatus);
}
