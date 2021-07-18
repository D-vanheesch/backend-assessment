package com.example.backend.controller;

import com.example.backend.model.RepairItem;
import com.example.backend.service.RepairItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/repair-items")
public class RepairItemController {

    @Autowired
    private RepairItemService repairItemService;
    //krijgt verzoek binnen

    @GetMapping("")
    public ResponseEntity<Object> getRepairItem() {
        return ResponseEntity.ok(repairItemService.getRepairItem());
    }
    //create employee rest API

    @PostMapping("")
    public ResponseEntity<Object> addCar(@RequestBody RepairItem repairItem) {
        repairItemService.addRepairItem(repairItem);
        return ResponseEntity.ok("Added");
    }
    //get 1 employee
    //krijgt verzoek binnen
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRepairItem(@PathVariable("id") long id) {
        RepairItem repairItem = repairItemService.getRepairItem(id);
        return ResponseEntity.ok(repairItem);
    }
    //query to search on firstname (customers/firstname?firstname=David
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRepairItem(@PathVariable("id") long id, @RequestBody RepairItem updateRepairItem) {
        repairItemService.updateRepairItem(id, updateRepairItem);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeRepairItem(@PathVariable("id") long id) {
        repairItemService.removeRepairItem(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}
