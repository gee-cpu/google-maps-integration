package com.gonchaba.maps.dto.responsedto;

import com.gonchaba.maps.model.GeocodingResult;
import lombok.Data;

import java.util.List;

@Data
public class GeocodingResponseDTO {
    private List<GeocodingResult> results;
    private String status;
}
