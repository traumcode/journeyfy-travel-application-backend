package com.journeyfy.journeyfytravelapplication.components.trips;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.journeyfy.journeyfytravelapplication.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Trip {
    @Id
    @SequenceGenerator(name = "trip_sequence", sequenceName = "trip_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_sequence")
    private Long id;
    private String cityName;
    private double budget;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "activity_entity_id")
    private Entity entity;

    public Trip(String cityName, String name, double budget, Entity entity) {
        this.cityName = cityName;
        this.name = name;
        this.budget = budget;
        this.entity = entity;
    }
}
