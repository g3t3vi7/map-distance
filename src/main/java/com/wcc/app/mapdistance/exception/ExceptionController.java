package com.wcc.app.mapdistance.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(PostCodeNotFound.class)
    public ResponseEntity<Object> recordExistException(PostCodeNotFound exception) {
        logger.error(String.format("Error thrown: %s",  exception.getErrorMsg()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getErrorMsg());
    }
}