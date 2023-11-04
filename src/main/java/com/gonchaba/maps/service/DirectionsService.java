package com.gonchaba.maps.service;

import com.gonchaba.maps.dto.requestdto.DirectionsRequestDTO;
import com.gonchaba.maps.model.Direction;

public interface DirectionsService {

    Direction getDirections(DirectionsRequestDTO requestDTO);
}
