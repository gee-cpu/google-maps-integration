package com.gonchaba.maps.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "locations")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double lat;
    private double lng;

    @OneToOne(cascade = CascadeType.ALL)
    private Geometry geometry;

}
