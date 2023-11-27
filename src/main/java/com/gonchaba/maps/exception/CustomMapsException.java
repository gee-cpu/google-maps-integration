package com.gonchaba.maps.exception;

import lombok.Data;

@Data
public class CustomMapsException extends RuntimeException {

    private String errorCode;
    private int status;

    public CustomMapsException(String message, String errorCode, int status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

}
