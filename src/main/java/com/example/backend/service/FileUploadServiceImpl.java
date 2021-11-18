package com.example.backend.service;

import com.example.backend.exception.FileStorageException;
import com.example.backend.exception.RecordNotFoundException;
import com.example.backend.model.FileUpload;
import com.example.backend.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    private FileUploadRepository fileUploadRepository;

    /**
     * Define fileUpLoad repository with fileUpLoad repository
     *
     * @param fileUploadRepository object to define fileUpLoadRepository
     */
    @Autowired
    public FileUploadServiceImpl(FileUploadRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }


    /**
     * Get all files
     *
     * @return fileUploadRepository.findAll()
     */
    @Override
    public Iterable<FileUpload> getFiles() {
        return fileUploadRepository.findAll();
    }

    /**
     * Upload new file and return insertion id
     *
     * @param file file contents to upload
     *
     * @return storedFile.getId()
     * @throws FileStorageException()
     */
    @Override
    public long uploadFile(MultipartFile file) {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "./Uploads";
        Path copyLocation = Paths.get(uploadDir + File.separator + originalFilename);

        try {
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

            FileUpload newFileToStore = new FileUpload();
            newFileToStore.setFileName(originalFilename);
            newFileToStore.setLocation(copyLocation.toString());

            FileUpload storedFile = fileUploadRepository.save(newFileToStore);
            System.out.println(storedFile);

            return storedFile.getId();
        } catch (Exception e) {
            throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!");
        }
    }

    /**
     * Delete file repository by id
     *
     * @param id file id to remove
     */
    @Override
    public void deleteFile(long id) {
        fileUploadRepository.deleteById(id);
    }

    /**
     * Download file by id
     *
     * @param id file id to download
     *
     * @return resource
     * @throws RecordNotFoundException()
     * @throws RecordNotFoundException()
     */
    @Override
    public Resource downloadFile(long id) {
        Path uploads = Paths.get("./Uploads");
        Optional<FileUpload> stored = fileUploadRepository.findById(id);

        if (stored.isPresent()) {
            String filename = stored.get().getFileName();
            Path path = uploads.resolve(filename);

            Resource resource = null;
            try {
                resource = new UrlResource(path.toUri());
                return resource;
            } catch (MalformedURLException e) {
                throw new RecordNotFoundException("File not available");
            }
        }
        else {
            throw new RecordNotFoundException("Error");
        }
    }

    /**
     * Get file by id
     *
     * @param id file id to get file content
     * @return fileUpload.get()
     * @throws RecordNotFoundException()
     */
    @Override
    public FileUpload getFileById(long id) {
        Optional<FileUpload> fileUpload = fileUploadRepository.findById(id);

        if (fileUpload.isPresent()){
            return fileUpload.get();
        }else{
            throw new RecordNotFoundException("File does not exist");
        }
    }

    /**
     * Get file existence
     *
     * @param id file id to find
     */
    @Override
    public boolean fileExistsById(long id) {
        return fileUploadRepository.existsById(id);
    }
}
