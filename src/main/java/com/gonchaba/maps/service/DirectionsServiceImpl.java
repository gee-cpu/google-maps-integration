package com.gonchaba.maps.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonchaba.maps.client.DirectionsClient;
import com.gonchaba.maps.config.GoogleMapsConfig;
import com.gonchaba.maps.dto.requestdto.DirectionsRequestDTO;
import com.gonchaba.maps.dto.responsedto.DirectionsResponseDTO;
import com.gonchaba.maps.model.Direction;
import com.gonchaba.maps.repository.DirectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DirectionsServiceImpl implements DirectionsService {
    private final DirectionsClient directionsClient;
    private final DirectionRepository directionRepository;
    private final ObjectMapper objectMapper;
    @Qualifier("primaryGoogleMapsConfig")
    GoogleMapsConfig mapsConfig;

    public DirectionsServiceImpl(DirectionsClient directionsClient, DirectionRepository directionRepository, GoogleMapsConfig mapsConfig, ObjectMapper objectMapper) {
        this.directionsClient = directionsClient;
        this.directionRepository = directionRepository;
        this.mapsConfig = mapsConfig;
        this.objectMapper = objectMapper;
    }

    @Override
    public Direction getDirections(DirectionsRequestDTO requestDTO) {
        Direction cachedDirection = directionRepository.findByOriginLatAndOriginLngAndDestinationLatAndDestinationLng(
                requestDTO.getOriginLat(), requestDTO.getOriginLng(),
                requestDTO.getDestinationLat(), requestDTO.getDestinationLng()
        );

        if (cachedDirection != null) {
            return cachedDirection;
        }

        DirectionsResponseDTO responseDTO = directionsClient.getDirections(
                requestDTO.getOriginLat() + "," + requestDTO.getOriginLng(),
                requestDTO.getDestinationLat() + "," + requestDTO.getDestinationLng(),
                mapsConfig.getKey()
        );

        Direction direction = convertResponseToModel(responseDTO);

        if (direction != null) {

            directionRepository.save(direction);
        }else {
            log.info("You are trying to save a null value");
        }

        return direction;
    }

   /* private Direction convertResponseToModel(DirectionsResponseDTO responseDTO) {
        Direction direction = new Direction();
        direction.setRoutes(responseDTO.getDirection().getRoutes());
        return direction;
    }*/

    private Direction convertResponseToModel(DirectionsResponseDTO responseDTO) {
        return objectMapper.convertValue(responseDTO.getDirection(), Direction.class);
    }
}
