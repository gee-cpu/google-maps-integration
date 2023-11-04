package com.gonchaba.maps.service;

import com.gonchaba.maps.dto.requestdto.PlacesRequestDTO;
import com.gonchaba.maps.dto.responsedto.PlacesResponseDTO;

public interface PlacesService {
    PlacesResponseDTO findNearbyPoliceStations(PlacesRequestDTO requestDTO);
}

