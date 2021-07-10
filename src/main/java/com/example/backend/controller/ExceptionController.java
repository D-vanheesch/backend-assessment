package com.example.backend.controller;

import com.example.backend.exception.FileStorageException;
import com.example.backend.exception.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = FileStorageException.class)
    public ResponseEntity<Object> exception(FileStorageException exception) {
        return ResponseEntity.badRequest().build();
    }
}
