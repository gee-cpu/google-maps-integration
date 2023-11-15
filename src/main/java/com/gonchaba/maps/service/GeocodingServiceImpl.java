
package com.gonchaba.maps.service;


import com.gonchaba.maps.config.GoogleMapsConfig;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Qualifier;
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
            return GeocodingApi.geocode(geoApiContext, address).await()[0];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
