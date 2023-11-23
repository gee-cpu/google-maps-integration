package com.gonchaba.maps.controlleradvice;

import com.gonchaba.maps.exception.DirectionsException;
import com.gonchaba.maps.exception.GeocodingException;
import com.gonchaba.maps.exception.PlacesException;
import com.gonchaba.maps.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DirectionsException.class)
    public ResponseEntity<ErrorMessage> handleDirectionsException(DirectionsException ex) {
        return new ResponseEntity<>(new ErrorMessage()
                .builder().errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GeocodingException.class)
    public ResponseEntity<ErrorMessage> handleGeocodingException(GeocodingException ex) {
        return new ResponseEntity<>(new ErrorMessage()
                .builder().errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlacesException.class)
    public ResponseEntity<ErrorMessage> handlePlacesException(PlacesException ex) {
        return new ResponseEntity<>(new ErrorMessage()
                .builder().errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage("An unexpected error occurred.", "INTERNAL_SERVER_ERROR"));
    }
}
