package com.example.airpark.controller;

import com.example.airpark.service.exception.AlreadyExistException;
import com.example.airpark.service.exception.ValidationException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {


        // ------- методы для выполнения в случае возникновения exception в ходе работы приложения -----
        @ExceptionHandler(AlreadyExistException.class)
        public ResponseEntity<String> handlerAlreadyExistException(AlreadyExistException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
        public ResponseEntity<String> handlerNotFoundException(ChangeSetPersister.NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(ValidationException.class)
        public ResponseEntity<String> handlerValidationException(ValidationException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


        @ExceptionHandler(NullPointerException.class)
        public ResponseEntity<String> handlerNullPointerException(NullPointerException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<String> handlerConstraintViolationException(ConstraintViolationException e){

            StringBuilder responseMessage = new StringBuilder();

            e.getConstraintViolations().forEach(
                    constraintViolation -> {
                        String currentErrorMessage = constraintViolation.getMessage();
                        responseMessage.append(currentErrorMessage);
                        responseMessage.append("\n");
                    }
            );

            return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<String> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){

            StringBuilder responseMessage = new StringBuilder();

            e.getBindingResult().getAllErrors().forEach(
                    objectError -> {
                        String fieldName = ((FieldError) objectError).getField();
                        String currentErrorMessage = objectError.getDefaultMessage();
                        responseMessage.append(fieldName + " : " + currentErrorMessage);
                        responseMessage.append("\n");
                    }
            );

            return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
        }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>("Internal server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>("Malformed JSON request", HttpStatus.BAD_REQUEST);
    }



}

