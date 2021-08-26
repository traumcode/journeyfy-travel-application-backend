package com.journeyfy.journeyfytravelapplication.activityentity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import com.journeyfy.journeyfytravelapplication.posts.Post;
import com.journeyfy.journeyfytravelapplication.wishes.Wish;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@javax.persistence.Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.STRING)
@EqualsAndHashCode
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
    protected List<Wish> wishes;
    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL)
    @JsonIgnore
    protected List<Post> posts;


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
}
