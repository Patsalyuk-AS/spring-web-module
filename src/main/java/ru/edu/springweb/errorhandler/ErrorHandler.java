package ru.edu.springweb.errorhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static ru.edu.springweb.errorhandler.ErrorDescription.SYSTEM_UNAVAILABLE;

@RestControllerAdvice
public class ErrorHandler {

    Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(BookException.class)
    public ResponseEntity<String> handleException(BookException ex) {
        log.info(ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatusCode()).body(ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error("Exception: {}", ex.getMessage());
        System.out.println(ex);
        return ResponseEntity.status(SYSTEM_UNAVAILABLE.getCode()).body(SYSTEM_UNAVAILABLE.getDescription());
    }

}
