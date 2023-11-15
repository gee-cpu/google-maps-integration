package com.gonchaba.maps.service;

import com.gonchaba.maps.config.GoogleMapsConfig;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlacesServiceImpl implements PlacesService {
    private final GeoApiContext geoApiContext;

    public PlacesServiceImpl(GoogleMapsConfig mapsConfig) {
        this.geoApiContext = new GeoApiContext.Builder()
                .apiKey(mapsConfig.getKey())
                .build();
    }

    @Override
    public PlacesSearchResponse searchPlaces(String query) {
        try {
            return PlacesApi.textSearchQuery(geoApiContext, query).await();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PlaceDetails getPlaceDetails(String placeId) {
        try {
            return PlacesApi.placeDetails(geoApiContext, placeId).await();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}