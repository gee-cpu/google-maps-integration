package com.gonchaba.maps.exception;


public class PlacesException extends RuntimeException {

    public PlacesException(String message) {
        super(message);
    }

    public PlacesException(String message, Throwable cause) {
        super(message, cause);
    }
}
