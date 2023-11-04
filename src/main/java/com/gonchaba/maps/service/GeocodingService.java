package com.gonchaba.maps.service;

import com.gonchaba.maps.dto.requestdto.GeocodingRequestDTO;
import com.gonchaba.maps.dto.responsedto.GeocodingResponseDTO;

public interface GeocodingService {
    GeocodingResponseDTO geocode(GeocodingRequestDTO requestDTO);
}
