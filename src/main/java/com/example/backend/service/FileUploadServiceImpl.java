package com.example.backend.service;

import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.FileUpload;
import com.example.backend.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    private FileUploadRepository fileUploadRepository;
    @Autowired
    public FileUploadServiceImpl(FileUploadRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }
    @Override
    public Iterable<FileUpload> getFiles() {
        return fileUploadRepository.findAll();
    }
    @Override
    public long uploadFile(MultipartFile file) {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
//        Path copyLocation = Paths.get(uploadDir + File.separator + originalFilename);
//
//        try {
//            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
//        } catch (Exception e) {
//            throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!");
//        }
        FileUpload newFileToStore = new FileUpload();
        newFileToStore.setFileName(originalFilename);
//        newFileToStore.setLocation(copyLocation.toString());
        FileUpload storedFile = fileUploadRepository.save(newFileToStore);
        return storedFile.getId();
    }
    @Override
    public void deleteFile(long id) {
//        if (!fileUploadRepository.existsById(id)) throw new RecordNotFoundException("file doesn't exist");
        fileUploadRepository.deleteById(id);
    }

    @Override
    public FileUpload getFileById(long id) {
        Optional<FileUpload> fileUpload = fileUploadRepository.findById(id);
//        if (!fileUploadRepository.existsById(id)) throw new RecordNotFoundException("file doesn't exist");
//        return fileUploadRepository.findById(id);
        if (fileUpload.isPresent()){
            return fileUpload.get();
        }else{
            throw new RecordNotFoundException("File does not exist");
        }
    }
    @Override
    public boolean fileExistsById(long id) {
        return fileUploadRepository.existsById(id);
    }
}
