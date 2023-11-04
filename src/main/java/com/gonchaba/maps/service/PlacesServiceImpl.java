/*
package com.gonchaba.maps.service;

import com.gonchaba.maps.client.PlacesClient;
import com.gonchaba.maps.dto.requestdto.PlacesRequestDTO;
import com.gonchaba.maps.dto.responsedto.PlacesResponseDTO;
import com.gonchaba.maps.model.Place;
import com.gonchaba.maps.repository.PlacesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesServiceImpl implements PlacesService {
    private final PlacesClient placesClient;
    private final PlacesRepository placesRepository;

    public PlacesServiceImpl(PlacesClient placesClient, PlacesRepository placesRepository) {
        this.placesClient = placesClient;
        this.placesRepository = placesRepository;
    }

    @Override
    @Transactional
    public PlacesResponseDTO findNearbyPoliceStations(PlacesRequestDTO requestDTO) {

        PlacesResponseDTO cachedResults = placesRepository.findByLocationAndRadius(requestDTO.getLocation(), requestDTO.getRadius());

        if (cachedResults != null) {
            return cachedResults;
        } else {
            PlacesResponseDTO responseDTO = placesClient.findNearbyPoliceStations(
                    requestDTO.getLocation(),
                    requestDTO.getRadius(),
                    requestDTO.getKeyword(),
                    requestDTO.getApiKey()
            );

            if ("OK".equals(responseDTO.getStatus())) {
                List<Place> places = responseDTO.getResults();
                placesRepository.saveAll(places);
                return responseDTO;
            }

            return responseDTO;
        }
    }
}
*/
