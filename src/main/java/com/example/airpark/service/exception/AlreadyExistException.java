package com.example.airpark.service.exception;

import org.springframework.http.ResponseEntity;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {
        super(message);
    }
}
