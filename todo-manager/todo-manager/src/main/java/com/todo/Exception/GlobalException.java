package com.todo.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    Logger logger = LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleGlobalException(NullPointerException ex){
            logger.info(ex.getMessage());
            return new ResponseEntity<>("Handle Global exception", HttpStatus.BAD_REQUEST);
    }

    // Custom Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourcesNotFoundException(ResourceNotFoundException ex){
        logger.error("Error {}",ex.getMessage());
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND);
        exceptionResponse.setSuccess(false);
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
