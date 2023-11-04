package com.gonchaba.maps.dto.requestdto;

import lombok.Data;

@Data
public class GeocodingRequestDTO {
    private String address;
    private String key;
}
