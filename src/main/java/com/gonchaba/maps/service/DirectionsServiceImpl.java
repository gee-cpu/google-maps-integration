package com.gonchaba.maps.service;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DirectionsServiceImpl implements DirectionsService {

    private final GeoApiContext geoApiContext;


    public DirectionsServiceImpl(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    @Override
    public DirectionsRoute getDirections(String origin, String destination) throws ApiException, InterruptedException, IOException {
        DirectionsApiRequest request = DirectionsApi.newRequest(geoApiContext)
                .origin(origin)
                .destination(destination)
                .mode(TravelMode.DRIVING);

        DirectionsResult result = request.await();
        return result.routes[0];
    }
}
