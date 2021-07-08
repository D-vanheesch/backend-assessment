package com.example.backend.service;

import com.example.backend.model.RepairJob;

import java.util.List;

public interface RepairJobService {
    List<RepairJob> getRepairJob();
    RepairJob getRepairJob (long id);
    RepairJob addRepairJob (RepairJob repairJob);
    void removeRepairJob(long id);
    void updateRepairJob(long id, RepairJob repairJob);

}
