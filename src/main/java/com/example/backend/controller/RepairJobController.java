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

        /**
         * Map getAllRepairJobs to get all repair jobs
         *
         * @return ok || badRequest
         */
        @GetMapping("")
        public ResponseEntity<Object> getAllRepairJobs() {
            if (repairJobService.getRepairJob() != null) {
                return ResponseEntity.ok(repairJobService.getRepairJob());
            } else {
                return ResponseEntity.badRequest().body("No repair jobs found.");
            }
        }

        /**
         * Map addRepairJob insert repair jobs with new attributes
         *
         * @param repairJobInformation the attributes for new repair jobs
         *
         * @return ok
         */
        @PostMapping("")
        public ResponseEntity<Object> addRepairJob(@RequestBody RepairJobDto repairJobInformation) {
            repairJobService.addRepairJob(repairJobInformation);
            return ResponseEntity.ok("Added");
        }

        /**
         * Map getRepairJob to get repair jobs by id
         *
         * @param id get repair jobs by id
         *
         * @return ok || badRequest
         */
        @GetMapping("/{id}")
        public ResponseEntity<Object> getRepairJobById(@PathVariable("id") long id) {
            if (repairJobService.getRepairJob() != null) {
                RepairJob repairJob = repairJobService.getRepairJob(id);
                return ResponseEntity.ok(repairJob);
            } else {
                return ResponseEntity.badRequest().body("Id not found.");
            }
        }

        /**
         * Map getByCustomerAgrees to get all repair jobs by customer agrees
         *
         * @param customerAgrees get repair jobs by customer agrees status
         *
         * @return customers
         */
        @GetMapping("/customerAgrees")
        public List<CustomerDto> getByCustomerAgrees(@RequestParam String customerAgrees) {

            var repairJobs = repairJobService.getByCustomerAgrees(customerAgrees);
            var customers = new ArrayList<CustomerDto>();
            for (int i = 0; i < repairJobs.size(); i++) {
                var customerInformation =  CustomerDto.fromCustomer(repairJobs.get(i).getCustomer());
                customers.add(customerInformation);
            }
            return customers;
        }

        /**
         * Map getRepairJobByStatus to get repair jobs by status
         *
         * @param repairStatus get repair jobs by repair status
         *
         * @return repairStatusCheck
         */
        @GetMapping("/repairStatus")
        public ArrayList<RepairJobDto> getRepairJobByStatus(@RequestParam String repairStatus){

            var repairJobStatus = repairJobService.getByRepairStatus(repairStatus);
            var repairStatusCheck = new ArrayList<RepairJobDto>();
            for (int i = 0; i < repairJobStatus.size(); i++) {
                var repairJobs = RepairJobDto.fromRepairStatus(repairJobStatus.get(i).getCustomer().getRepairJob());
                repairStatusCheck.add(repairJobs);
            }
            return repairStatusCheck;
        }

        /**
         * Map updateRepairJob to update repair jobs by id
         *
         * @param id repairJob id to update
         * @param repairJobInformation new repair job information
         *
         * @return ok
         */
        @PutMapping("/{id}")
        public ResponseEntity<Object> updateRepairJob(@PathVariable("id") long id, @RequestBody RepairJob repairJobInformation) {
            repairJobService.updateRepairJob(id, repairJobInformation);
            return ResponseEntity.ok("successfully updated.");
        }

        /**
         * Map removeRepairJob to remove repair jobs by id
         *
         * @param id repair job id to remove
         *
         * @return ok
         */
        @DeleteMapping("/{id}")
        public ResponseEntity<Object> removeRepairJob (@PathVariable("id") long id) {
            repairJobService.removeRepairJob(id);
            return ResponseEntity.ok("Deleted");
        }
}
