package com.maxim.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> exceptionHandler(Exception e) { // более глобальный на случай выпадения ошибок которые не обрабтаны другими методами
        System.out.println("ExceptionHadler: " + e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {SecurityNotFound.class})
    public ResponseEntity<String> SecurityNotFoundExceptionHandler(SecurityNotFound e) {
        System.out.println("ExceptionHadler: " + e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<String> httpMessageNotReadableExceptionHandler (SecurityNotFound e) {
        System.out.println("ExceptionHadler: " + e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomFileException.class)
    public ResponseEntity<String> FileUploadExceptionExceptionHandler (CustomFileException e) {
        System.out.println("ExceptionHadler: " + e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<String> FileNotFoundExceptionHandler (FileNotFoundException e) {
        System.out.println("ExceptionHadler: " + e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
