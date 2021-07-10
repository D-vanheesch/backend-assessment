package com.example.backend.controller;

import com.example.backend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/file-upload")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("")
    public ResponseEntity<Object> getFilesInfo() {
        return ResponseEntity.ok(fileUploadService.getFiles());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getFileInfo(@PathVariable("id") long id) {
        fileUploadService.getFileById(id);
        return ResponseEntity.ok(fileUploadService.getFileById(id));
    }
    //    @GetMapping("/repair-items/{id}")
//    public ResponseEntity<Object> getRepairItem(@PathVariable("id") long id) {
//        RepairItem repairItem = repairItemService.getRepairItem(id);
//        return ResponseEntity.ok(repairItem);
//    }
//    @GetMapping("/files/id")
//    public ResponseEntity<Object> getFileData(@PathVariable long id) {
//        return ResponseEntity.ok(fileUploadService.getFileById(id));
//    }
    @PostMapping("")
    public ResponseEntity<Object> uploadFile(@RequestBody MultipartFile file) {
        fileUploadService.uploadFile(file);
        return ResponseEntity.ok("Added");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable("id") long id) {
        fileUploadService.deleteFile(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }

}
