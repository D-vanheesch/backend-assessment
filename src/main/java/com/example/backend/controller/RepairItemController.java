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

    /**
     * Map getAllRepairItems to get all repair items
     *
     * @return ok || badRequest
     */
    @GetMapping("")
    public ResponseEntity<Object> getAllRepairItems() {
        if (repairItemService.getRepairItem() != null) {
            return ResponseEntity.ok(repairItemService.getRepairItem());
        } else {
            return ResponseEntity.badRequest().body("No repair items found.");
        }
    }

    /**
     * Map addRepairItem to add repair items
     *
     * @param repairItem attributes to add to a new repair item
     *
     * @return ok
     */
    @PostMapping("")
    public ResponseEntity<Object> addRepairItem(@RequestBody RepairItem repairItem) {
        repairItemService.addRepairItem(repairItem);
        return ResponseEntity.ok("Added");
    }

    /**
     * Map getRepairItem to get repair items by id
     *
     * @param id to get repair items by id
     *
     * @return ok || badRequest
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRepairItem(@PathVariable("id") long id) {
        if (repairItemService.getRepairItem() != null) {
            RepairItem repairItem = repairItemService.getRepairItem(id);
            return ResponseEntity.ok(repairItem);
        } else {
            return ResponseEntity.badRequest().body("No repair item found by this id.");
        }
    }

    /**
     * Map updateRepairItem to add information on repair items id
     *
     * @param id to get repair items by id
     * @param updateRepairItem to add information in repair items
     *
     * @return ok
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRepairItem(@PathVariable("id") long id, @RequestBody RepairItem updateRepairItem) {
        repairItemService.updateRepairItem(id, updateRepairItem);
        return ResponseEntity.ok("Repair items successfully updated.");
    }

    /**
     * Map removeRepairItem removing repair items with id
     *
     * @param id to remove repair items by id
     *
     * @return ok
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeRepairItem(@PathVariable("id") long id) {
        repairItemService.removeRepairItem(id);
        return ResponseEntity.noContent().build().ok("Deleted.");
    }
}