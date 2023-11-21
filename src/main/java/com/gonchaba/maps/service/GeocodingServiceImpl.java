package com.gonchaba.maps.service;


import com.gonchaba.maps.config.GoogleMapsConfig;
import com.gonchaba.maps.exception.GeocodingException;
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

    /*@Override
    public GeocodingResult geocodeAddress(String address) {
        try {
            return GeocodingApi.geocode(geoApiContext, address).await()[0];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
    @Override
    public GeocodingResult geocodeAddress(String address) {
        try {
            GeocodingResult[] results = GeocodingApi.geocode(geoApiContext, address).await();
            if (results.length > 0) {
                return results[0];
            } else {
                throw new GeocodingException("No geocoding results found for the given address: " + address);
            }
        } catch (Exception e) {
            throw new GeocodingException("Error occurred while geocoding address: " + address, e);
        }
    }
}
