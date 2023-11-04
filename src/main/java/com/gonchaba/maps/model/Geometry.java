package com.gonchaba.maps.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "geometries")
@Data
public class Geometry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "geometry", cascade = CascadeType.ALL)
    private Location location;

    private String locationType;
}
