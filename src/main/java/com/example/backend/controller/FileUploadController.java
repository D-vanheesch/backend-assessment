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

    /**
     * Map getFilesInfo get file information
     *
     * @return ok || badRequest
     */
    @GetMapping("")
    public ResponseEntity<Object> getFilesInfo() {
        if (fileUploadService.getFiles() != null) {
            return ResponseEntity.ok(fileUploadService.getFiles());
        } else {
            return ResponseEntity.badRequest().body("File not found.");
        }
    }

    /**
     * Map getFileInfo to get file information by fileId
     *
     * @param id find file information by id
     *
     * @return ok || badRequest
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getFileInfo(@PathVariable("id") long id) {
        if (fileUploadService.getFileById(id) != null) {
            fileUploadService.getFileById(id);
            return ResponseEntity.ok(fileUploadService.getFileById(id));
        } else {
            return ResponseEntity.badRequest().body("File not found.");
        }
    }

    /**
     * Map downloadFile to download the file by id
     *
     * @param id file id to download
     *
     * @return ok || badRequest
     */
    @GetMapping("/{id}/download")
    public ResponseEntity downloadFile(@PathVariable("id") long id) {
        if (fileUploadService.getFileById(id) != null) {
            Resource resource = fileUploadService.downloadFile(id);
            String mediaType = "application/octet-stream";
            String fileName = fileUploadService.getFileById(id).getFileName();
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(mediaType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.badRequest().body("File not found.");
        }
    }

    /**
     * Map uploadFile to upload the file
     *
     * @param file file content
     *
     * @return ok
     */
    @PostMapping("")
    public ResponseEntity<Object> uploadFile(@RequestBody MultipartFile file) {
        fileUploadService.uploadFile(file);
        return ResponseEntity.ok("Added");
    }

    /**
     * Map deleteFile to delete file by id
     *
     * @param id file id to delete
     *
     * @return ok
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable("id") long id) {
        fileUploadService.deleteFile(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}
