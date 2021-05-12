package com.mindtech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException exception, WebRequest request) {
        ExceptionDetailsWrapper exceptionDetailsWrapper = new ExceptionDetailsWrapper(exception.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(exceptionDetailsWrapper, HttpStatus.NOT_FOUND);
    }
}
