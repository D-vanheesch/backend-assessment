package com.example.backend.service;

import com.example.backend.controller.dto.RepairJobDto;
import com.example.backend.exception.BadRequestException;
import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.Customer;
import com.example.backend.model.RepairItem;
import com.example.backend.model.RepairJob;
import com.example.backend.repository.CustomerRepository;
import com.example.backend.repository.RepairItemRepository;
import com.example.backend.repository.RepairJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairJobServiceImpl implements RepairJobService {
    private final RepairJobRepository repairJobRepository;

    /**
     * Define repairJobServiceImpl repository with repairJob repository
     *
     * @param repairJobRepository to add repairJob repository to repairJob repository
     */
    @Autowired
    public RepairJobServiceImpl(RepairJobRepository repairJobRepository) {
        this.repairJobRepository = repairJobRepository;
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RepairItemRepository repairItemRepository;

    /**
     * Get all repairJobs
     *
     * @return repairJobRepository.findAll()
     */
    @Override
    public List<RepairJob> getRepairJob() {
        return repairJobRepository.findAll();
    }

    /**
     * Get repairJob repository by id
     *
     * @param id repairJob id to find
     *
     * @return repairJob.get()
     * @throws RecordNotFoundException Repairjob does not exist
     */
    @Override
    public RepairJob getRepairJob ( long id) {
        Optional<RepairJob> repairJob = repairJobRepository.findById(id);
        if (repairJob.isPresent()) {
            return repairJob.get();
        } else {
            throw new RecordNotFoundException("Repairjob does not exist");
        }
    }

    /**
     * Find repair jobs by customerAgrees
     *
     * @param customerAgrees customerAgrees to find all repairJobs
     *
     * @return optionalRepairJob
     *
     */
    @Override
    public List<RepairJob> getByCustomerAgrees(String customerAgrees) {
        List<RepairJob> optionalRepairJob = repairJobRepository.findRepairJobsByCustomerAgrees(customerAgrees);
        return optionalRepairJob;
    }

    /**
     * Find repair jobs by repairStatus
     *
     * @param repairStatus repairStatus to find all repairJobs
     *
     * @return optionalRepairJob
     *
     */
    @Override
    public List<RepairJob> getByRepairStatus(String repairStatus) {
        List<RepairJob> optionalRepairJob = repairJobRepository.findRepairJobsByRepairStatus(repairStatus);
        return optionalRepairJob;
    }

    /**
     * Add repairJob
     *
     * @param repairJobDto repairJob information
     *
     * @return repairJob
     *
     */
    @Override
    public RepairJob addRepairJob (RepairJobDto repairJobDto){
        RepairJob repairJob = RepairJobDto.toRepairJob(repairJobDto);
        repairJob.setExamination(repairJobDto.getExamination());
        repairJob.setCustomerAgrees(repairJobDto.getCustomerAgrees());
        repairJob.setRepairStatus(repairJobDto.getRepairStatus());
        Customer customer = customerRepository.findById(repairJobDto.getCustomerId()).orElse(null);
        if (customer.getRepairJob()!=null) throw new BadRequestException();
        repairJob.setCustomer(customer);
        repairJob =  repairJobRepository.save(repairJob);
        for(RepairItem repairItem:repairJob.getRepairItem()){
            repairItemRepository.save(repairItem);
        }
        return repairJob;
    }

    /**
     * Remove repairJob by id
     *
     * @param id repairJob id to delete
     */
    @Override
    public void removeRepairJob ( long id){
        repairJobRepository.deleteById(id);
    }

    /**
     * Update repairJob by id
     *
     * @param id find repairJob repository by id
     * @param updateRepairJob update repairJob repository by id
     *
     * @throws RecordNotFoundException repairJob does not exist
     */
    @Override
    public void updateRepairJob(long id, RepairJob updateRepairJob) {
        Optional<RepairJob> optionalRepairJob = repairJobRepository.findById(id);
        if (optionalRepairJob.isPresent()) {
            repairJobRepository.save(updateRepairJob);
        } else {
            throw new RecordNotFoundException("Repairjob does not exist");
        }
    }
}


