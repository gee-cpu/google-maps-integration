package com.gonchaba.maps.service;

import com.gonchaba.maps.client.GeocodingClient;
import com.gonchaba.maps.dto.requestdto.GeocodingRequestDTO;
import com.gonchaba.maps.dto.responsedto.GeocodingResponseDTO;
import com.gonchaba.maps.model.AddressComponent;
import com.gonchaba.maps.model.GeocodingResult;
import com.gonchaba.maps.model.Geometry;
import com.gonchaba.maps.model.Location;
import com.gonchaba.maps.repository.AddressComponentRepository;
import com.gonchaba.maps.repository.GeocodingResultRepository;
import com.gonchaba.maps.repository.GeometryRepository;
import com.gonchaba.maps.repository.LocationRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GeocodingServiceImpl implements GeocodingService {
    private static final Logger logger = Logger.getLogger(GeocodingServiceImpl.class.getName());

    private final GeocodingClient geocodingClient;
    private final GeocodingResultRepository geocodingRepository;
    private final LocationRepository locationRepository;
    private final GeometryRepository geometryRepository;
    private final AddressComponentRepository addressComponentRepository;

    public GeocodingServiceImpl(GeocodingClient geocodingClient, GeocodingResultRepository geocodingRepository,
                                LocationRepository locationRepository, GeometryRepository geometryRepository,
                                AddressComponentRepository addressComponentRepository) {
        this.geocodingClient = geocodingClient;
        this.geocodingRepository = geocodingRepository;
        this.locationRepository = locationRepository;
        this.geometryRepository = geometryRepository;
        this.addressComponentRepository = addressComponentRepository;
    }

    @Override
    @Transactional
    public GeocodingResponseDTO geocode(GeocodingRequestDTO requestDTO) {
        logger.info("Received a geocoding request for address: " + requestDTO.getAddress());

        GeocodingResult cachedResult = geocodingRepository.findByFormattedAddress(requestDTO.getAddress());

        if (cachedResult != null) {
            logger.info("Using cached result for address: " + requestDTO.getAddress());
            return createResponseFromCachedResult(cachedResult);
        } else {
            GeocodingResponseDTO responseDTO = geocodingClient.geocodeAddress(requestDTO.getAddress(), requestDTO.getKey());

            if ("OK".equals(responseDTO.getStatus())) {
                logger.info("Geocoding request was successful for address: " + requestDTO.getAddress());
                GeocodingResult newResult = saveResultToDatabase(responseDTO);
                return createResponseFromCachedResult(newResult);
            }

            logger.warning("Geocoding request failed for address: " + requestDTO.getAddress() +
                    " with status: " + responseDTO.getStatus());
            return responseDTO;
        }
    }

    private GeocodingResponseDTO createResponseFromCachedResult(GeocodingResult result) {
        GeocodingResponseDTO responseDTO = new GeocodingResponseDTO();
        responseDTO.setStatus("OK");
        responseDTO.getResults().add(result);
        return responseDTO;
    }

    private GeocodingResult saveResultToDatabase(GeocodingResponseDTO responseDTO) {
        GeocodingResult result = responseDTO.getResults().get(0);

        Location location = locationRepository.save(result.getGeometry().getLocation());
        Geometry geometry = result.getGeometry();
        geometry.setLocation(location);
        Geometry savedGeometry = geometryRepository.save(geometry);

        for (AddressComponent addressComponent : result.getAddressComponents()) {
            addressComponent.setGeometry(savedGeometry);
            addressComponentRepository.save(addressComponent);
        }

        return geocodingRepository.save(result);
    }
}
