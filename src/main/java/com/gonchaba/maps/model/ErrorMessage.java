package com.gonchaba.maps.model;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {

    private String message;
    private HttpStatus status;

    public ErrorMessage(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

}
