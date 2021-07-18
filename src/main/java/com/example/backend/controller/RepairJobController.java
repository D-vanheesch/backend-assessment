package com.example.backend.controller;

import com.example.backend.controller.dto.CustomerDto;
import com.example.backend.controller.dto.RepairJobDto;
import com.example.backend.model.RepairJob;
import com.example.backend.repository.RepairItemRepository;
import com.example.backend.service.RepairJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/repair-jobs")
public class RepairJobController {

    @Autowired
    private RepairJobService repairJobService;

    @Autowired
    private RepairItemRepository repairItemRepository;

        @GetMapping("")
        public ResponseEntity<Object> getRepairJob() {
            return ResponseEntity.ok(repairJobService.getRepairJob());
        }

        @PostMapping("")
        public ResponseEntity<Object> addRepairJob(@RequestBody RepairJobDto repairJobDto) {
            repairJobService.addRepairJob(repairJobDto);
            return ResponseEntity.ok("Added");
        }

        @GetMapping("/{id}")
        public ResponseEntity<Object> getRepairJob(@PathVariable("id") long id) {
            RepairJob repairJob = repairJobService.getRepairJob(id);
            return ResponseEntity.ok(repairJob);
        }

        @GetMapping("/customerAgrees")
        public List<CustomerDto> getByCustomerAgrees(@RequestParam String customerAgrees) {

            var repairjobs = repairJobService.getByCustomerAgrees(customerAgrees);
            var phonenumbers = new ArrayList<CustomerDto>();
            for (int i = 0; i < repairjobs.size(); i++) {
                var dto =  CustomerDto.fromCustomer(repairjobs.get(i).getCustomer());
                phonenumbers.add(dto);
            }
            return phonenumbers;
        }

    @GetMapping("/repairStatus")
    public ArrayList<RepairJobDto> getByRepairStatus (@RequestParam String repairStatus){

        var repairjobs = repairJobService.getByRepairStatus(repairStatus);
        var repairStatusCheck = new ArrayList<RepairJobDto>();
        for (int i = 0; i < repairjobs.size(); i++) {
            var dto = RepairJobDto.fromRepairStatus(repairjobs.get(i).getCustomer().getRepairJob());
            repairStatusCheck.add(dto);
        }
        return repairStatusCheck;
    }

        @PutMapping("/{id}")
        public ResponseEntity<Object> updateRepairJob(@PathVariable("id") long id, @RequestBody RepairJob updateRepairJob) {
            repairJobService.updateRepairJob(id, updateRepairJob);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> removeRepairJob (@PathVariable("id") long id) {
            repairJobService.removeRepairJob(id);
            return ResponseEntity.noContent().build().ok("Deleted");
        }
}
