package com.gonchaba.maps.repository;


import com.gonchaba.maps.model.GeocodingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeocodingResultRepository extends JpaRepository<GeocodingResult, Long> {
    GeocodingResult findByFormattedAddress(String address);
}
