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

    /**
     * Define repairItemService repository with repairItem repository
     *
     * @param repairItemRepository to add repairItem repository to repairItem repository
     */
    @Autowired
    public RepairItemServiceImpl (RepairItemRepository repairItemRepository) {
        this.repairItemRepository = repairItemRepository;
    }

    /**
     * Get all repair items
     *
     * @return repairItemRepository.findAll()
     */
    @Override
    public List<RepairItem> getRepairItem() {
        return repairItemRepository.findAll();
    }

    /**
     * Get repairItem by id
     *
     * @param id repair item id to find
     *
     * @return repairItem.get()
     * @throws RecordNotFoundException RepairItem does not exist
     */
    @Override
    public RepairItem getRepairItem ( long id) {
        Optional<RepairItem> repairItem = repairItemRepository.findById(id);
        if (repairItem.isPresent()) {
            return repairItem.get();
        } else {
            throw new RecordNotFoundException("RepairItem does not exist");
        }
    }


    /**
     * Add repairItem
     *
     * @param repairItem repair item information
     *
     * @return repairItemRepository.save()
     */
    @Override
    public RepairItem addRepairItem (RepairItem repairItem){
        return repairItemRepository.save(repairItem);
    }

    /**
     * Remove repairItem by id
     *
     * @param id delete repairItem by id
     */
    @Override
    public void removeRepairItem ( long id) {
        repairItemRepository.deleteById(id);
    }

    /**
     * Update repairItem by id
     *
     * @param id repair item id to update
     * @param updateRepairItem new information of repairItem
     *
     * @throws RecordNotFoundException RepairJob does not exist
     */
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
