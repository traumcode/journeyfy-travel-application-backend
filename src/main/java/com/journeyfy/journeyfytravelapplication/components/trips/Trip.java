package com.journeyfy.journeyfytravelapplication.components.trips;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.journeyfy.journeyfytravelapplication.users.User;
import lombok.Getter;
import lombok.Setter;
import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Getter
@Setter
public class Trip {
    @Id
    @SequenceGenerator(name = "trip_sequence", sequenceName = "trip_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_sequence")
    private Long id;
    private int budget;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @ElementCollection
    private List<String> elements;
    //    @ManyToMany
//    @JoinColumn(name = "entity_id")
    @ManyToMany
    @JoinTable(
            name = "trip_entities",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id"))
    private List<Entity> entities;


}
