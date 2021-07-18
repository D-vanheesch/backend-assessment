package com.example.backend.service;

import com.example.backend.model.RepairItem;
import java.util.List;

public interface RepairItemService {
    List<RepairItem> getRepairItem();
    RepairItem getRepairItem (long id);
    RepairItem addRepairItem (RepairItem repairItem);
    void removeRepairItem(long id);
    void updateRepairItem(long id, RepairItem repairItem);
}
