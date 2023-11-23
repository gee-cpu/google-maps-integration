package com.gonchaba.maps.exception;

import lombok.Data;

@Data
public class GeocodingException extends RuntimeException{
    private String errorCode;

    public GeocodingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
