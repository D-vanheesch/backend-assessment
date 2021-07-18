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

    @GetMapping("")
    public ResponseEntity<Object> getRepairItem() {
        return ResponseEntity.ok(repairItemService.getRepairItem());
    }

    @PostMapping("")
    public ResponseEntity<Object> addCar(@RequestBody RepairItem repairItem) {
        repairItemService.addRepairItem(repairItem);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRepairItem(@PathVariable("id") long id) {
        RepairItem repairItem = repairItemService.getRepairItem(id);
        return ResponseEntity.ok(repairItem);
    }

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
