package com.gonchaba.maps.dto.requestdto;

import lombok.Data;

@Data

public class PlacesRequestDTO {
    private String location;
    private int radius;
    private String keyword;
    private String apiKey;

}
