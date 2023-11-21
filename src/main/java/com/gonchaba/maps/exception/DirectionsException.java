package com.gonchaba.maps.exception;


public class DirectionsException extends RuntimeException {

    public DirectionsException(String message) {
        super(message);
    }

    public DirectionsException(String message, Throwable cause) {
        super(message, cause);
    }
}
