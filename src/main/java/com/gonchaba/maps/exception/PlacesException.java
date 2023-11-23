package com.gonchaba.maps.exception;

import lombok.Data;

@Data
public class PlacesException extends RuntimeException {

    private String errorCode;

    public PlacesException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
