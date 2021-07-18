package com.example.backend.controller;

import com.example.backend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;


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

    @GetMapping("/{id}/download")
    public ResponseEntity downloadFile(@PathVariable("id") long id) {

        Resource resource = fileUploadService.downloadFile(id);
        String mediaType = "application/octet-stream";
        String fileName = fileUploadService.getFileById(id).getFileName();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

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
