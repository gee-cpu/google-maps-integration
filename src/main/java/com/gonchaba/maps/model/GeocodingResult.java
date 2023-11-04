package com.gonchaba.maps.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "geocoding_results")
@Data
public class GeocodingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "geocoding_result_id")
    private List<AddressComponent> addressComponents;

    private String formattedAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Geometry geometry;

    private String placeId;
    private String status;
}

