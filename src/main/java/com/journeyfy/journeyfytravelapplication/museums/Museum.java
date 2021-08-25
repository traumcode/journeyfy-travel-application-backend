package com.journeyfy.journeyfytravelapplication.museums;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.journeyfy.journeyfytravelapplication.posts.Post;
import com.journeyfy.journeyfytravelapplication.wishes.Wish;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "museum")
@Entity
public class Museum {
    @Id
    @SequenceGenerator(name = "museum_sequence", sequenceName = "museum_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "museum_sequence")
    private Long id;
    private String pictureLink;
    private String name;
    @Column(length = 10000)
    private String description;
    private double rating;
    private double price;
    private String cityName;
    private String siteLink;
    @OneToMany(mappedBy = "museum", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "museum")
    @JsonIgnore
    private List<Wish> wish;

    public Museum(String pictureLink, String name, String description, double rating, double price, String cityName, String siteLink) {
        this.pictureLink = pictureLink;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.cityName = cityName;
        this.siteLink = siteLink;
    }
}
