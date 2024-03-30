package com.gonchaba.maps.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonchaba.maps.model.ErrorMessage;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper mapper =
                new ObjectMapper();
        log.info("::{}", response.request().url());
        log.info("::{}", response.request().headers());

        try {
            ErrorMessage errorMessage
                    = mapper.readValue(response.body().asInputStream(), ErrorMessage.class);
            return new CustomMapsException(errorMessage.getMessage(), errorMessage.getErrorCode(), response.status());
        } catch (IOException e) {
            throw new CustomMapsException("Internal server error", "INTERNAL_SERVER_ERROR", 500);
        }
    }
}
