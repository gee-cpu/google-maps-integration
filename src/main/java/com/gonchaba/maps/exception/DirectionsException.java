package com.gonchaba.maps.exception;

import lombok.Data;

@Data
public class DirectionsException extends RuntimeException {

    private String errorCode;

    public DirectionsException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
