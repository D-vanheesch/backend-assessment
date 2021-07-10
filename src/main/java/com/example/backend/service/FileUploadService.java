package com.example.backend.service;

import com.example.backend.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    Iterable<FileUpload> getFiles();
    FileUpload getFileById(long id);
    boolean fileExistsById(long id);
    long uploadFile(MultipartFile file);
    void deleteFile(long id);
}
