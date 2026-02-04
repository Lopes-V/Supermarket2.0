package com.example.Supermarket20.controller.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public static StandardError ResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
        StandardError standardError = new StandardError(Instant.now(),404,"NOT FOUND",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(404).body(standardError).getBody();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public static StandardError NegocioException(ResourceNotFoundException e, HttpServletRequest r){
        StandardError standardError = new StandardError(Instant.now(),400,"BAD REQUEST",e.getMessage(),r.getRequestURI());
        return ResponseEntity.status(400).body(standardError).getBody();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public static StandardError DatabaseException(ResourceNotFoundException e, HttpServletRequest r){
        StandardError standardError = new StandardError(Instant.now(),400,"PRODUCT CANNOT BE EXCLUDED",e.getMessage(),r.getRequestURI());
        return ResponseEntity.status(400).body(standardError).getBody();
    }
}
