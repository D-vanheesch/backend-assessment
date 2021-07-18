package com.example.backend.service;

import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.RepairItem;
import com.example.backend.repository.RepairItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RepairItemServiceImpl implements RepairItemService {
    private RepairItemRepository repairItemRepository;

    @Autowired
    public RepairItemServiceImpl (RepairItemRepository repairItemRepository) {
        this.repairItemRepository = repairItemRepository;
    }

    @Override
    public List<RepairItem> getRepairItem() {
        return repairItemRepository.findAll();
    }

    @Override
    public RepairItem getRepairItem ( long id) {
        Optional<RepairItem> repairItem = repairItemRepository.findById(id);
        if (repairItem.isPresent()) {
            return repairItem.get();
        } else {
            throw new RecordNotFoundException("Repairitem does not exist");
        }
    }
    @Override
    public RepairItem addRepairItem (RepairItem repairItem){

        return repairItemRepository.save(repairItem);
    }
    @Override
    public void removeRepairItem ( long id){
        repairItemRepository.deleteById(id);
    }

    @Override
    public void updateRepairItem(long id, RepairItem updateRepairItem) {
        Optional<RepairItem> optionalRepairItem = repairItemRepository.findById(id);
        if (optionalRepairItem.isPresent()) {
            repairItemRepository.save(updateRepairItem);
        } else {
            throw new RecordNotFoundException("Repairjob does not exist");
        }
    }
}
