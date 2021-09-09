package com.journeyfy.journeyfytravelapplication.components.activityentity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import com.journeyfy.journeyfytravelapplication.components.posts.Post;
import com.journeyfy.journeyfytravelapplication.components.trips.Trip;
import com.journeyfy.journeyfytravelapplication.components.wishes.Wish;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@javax.persistence.Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorColumn(name = "type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Entity {
    @Id
    @SequenceGenerator(name = "activity_entity_sequence", sequenceName = "activity_entity_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_entity_sequence")
    private Long id;
    protected String pictureLink;
    @Column(length = 5000)
    protected String description;
    protected Double rating;
    protected Double price;
    protected String cityName;
    protected String name;
    protected Double hotelClass;
    protected String siteLink;
    protected String address;
    @Enumerated(EnumType.STRING)
    protected ActivityType activityType;
    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL)
    @JsonIgnore
    protected Set<Wish> wishes;
    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL)
    @JsonIgnore
    protected List<Post> posts;
    //    @ManyToMany(mappedBy = "entity", cascade = CascadeType.ALL)
//    @JsonIgnore
    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL)
    @JsonIgnore
    protected List<Trip> trips;


    public Entity(String pictureLink, String description, double rating, double price, String cityName, String name, String siteLink, String address, ActivityType activityType) {
        this.pictureLink = pictureLink;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.cityName = cityName;
        this.name = name;
        this.siteLink = siteLink;
        this.address = address;
        this.activityType = activityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id.equals(entity.id);
    }


}
