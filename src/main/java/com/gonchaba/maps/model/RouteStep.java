package com.gonchaba.maps.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "route_steps")
@Data
public class RouteStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;

}

