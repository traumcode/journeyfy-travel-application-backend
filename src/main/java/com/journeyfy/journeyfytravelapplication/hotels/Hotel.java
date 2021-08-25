package com.journeyfy.journeyfytravelapplication.hotels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.journeyfy.journeyfytravelapplication.posts.Post;
import com.journeyfy.journeyfytravelapplication.wishes.Wish;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel")
@Entity
public class Hotel {
    @Id
    @SequenceGenerator(name = "hotel_sequence", sequenceName = "hotel_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_sequence")
    private Long id;
    private String name;
    private double hotelClass;
    private String picture;
    @Column(length = 10000)
    private String description;
    private double price;
    private double rating;
    private String cityName;
    private String siteAddress;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    @JsonIgnore
    private List<Wish> wish;

}