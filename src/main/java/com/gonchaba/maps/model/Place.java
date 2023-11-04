package com.gonchaba.maps.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "places")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vicinity;

    @OneToOne(cascade = CascadeType.ALL)
    private Geometry geometry;

}
