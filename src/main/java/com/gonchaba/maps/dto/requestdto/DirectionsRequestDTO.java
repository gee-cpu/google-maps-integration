package com.gonchaba.maps.dto.requestdto;

import lombok.Data;

@Data
public class DirectionsRequestDTO {

    private double originLat;
    private double originLng;
    private double destinationLat;
    private double destinationLng;

}
