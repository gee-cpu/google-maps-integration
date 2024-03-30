package com.gonchaba.maps.service;


import com.gonchaba.maps.config.GoogleMapsConfig;
import com.gonchaba.maps.exception.CustomMapsException;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Service;

@Service
public class GeocodingServiceImpl implements GeocodingService {
    private final GeoApiContext geoApiContext;

    public GeocodingServiceImpl(GoogleMapsConfig mapsConfig) {
        this.geoApiContext = new GeoApiContext.Builder()
                .apiKey(mapsConfig.getKey())
                .build();
    }

    @Override
    public GeocodingResult geocodeAddress(String address) {
        try {
            GeocodingResult[] results = GeocodingApi.geocode(geoApiContext, address).await();
            if (results.length > 0) {
                return results[0];
            } else {
                throw new CustomMapsException("No geocoding results found for the given address: " + address, "NOT_FOUND", 404);
            }
        } catch (Exception e) {
            throw new CustomMapsException("Error occurred while geocoding address: " + address, "UNKNOWN_ERROR", 500);
        }
    }
}
