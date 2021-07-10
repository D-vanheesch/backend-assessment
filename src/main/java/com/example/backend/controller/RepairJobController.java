package com.example.backend.controller;

import com.example.backend.model.Customer;
import com.example.backend.model.RepairJob;
import com.example.backend.service.RepairJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair-jobs")
public class RepairJobController {

    @Autowired
    private RepairJobService repairJobService;

        //krijgt verzoek binnen
        @GetMapping("")
        public ResponseEntity<Object> getRepairJob() {
            return ResponseEntity.ok(repairJobService.getRepairJob());
        }
        //create employee rest API
        @PostMapping("")
        public ResponseEntity<Object> addRepairJob(@RequestBody RepairJob repairJob) {
            repairJobService.addRepairJob(repairJob);
            return ResponseEntity.ok("Added");
        }
        //get 1 employee
        //krijgt verzoek binnen
        @GetMapping("/{id}")
        public ResponseEntity<Object> getRepairJob(@PathVariable("id") long id) {
            RepairJob repairJob = repairJobService.getRepairJob(id);
            return ResponseEntity.ok(repairJob);
        }

        @GetMapping("/customerAgrees")
        public RepairJob getRepairJob(@RequestParam String customerAgrees) {
        return repairJobService.getByCustomerAgrees(customerAgrees);
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
