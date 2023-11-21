package com.gonchaba.maps.controlleradvice;


import com.gonchaba.maps.exception.DirectionsException;
import com.gonchaba.maps.exception.GeocodingException;
import com.gonchaba.maps.exception.PlacesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({DirectionsException.class, GeocodingException.class, PlacesException.class})
    @ResponseBody
    public ResponseEntity<String> handleCustomExceptions(RuntimeException ex) {
        logger.error("An exception occurred:", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Parameter out of range.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        logger.error("An unexpected error occurred:", ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred. Please contact support.");
    }
}

