package com.journeyfy.journeyfytravelapplication.clubs;

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
@Table(name = "club")
@Entity
public class Club {
    @Id
    @SequenceGenerator(name = "club_sequence", sequenceName = "club_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_sequence")
    private Long id;
    private String name;
    private String address;
    private String cityName;
    @Column(length = 60000)
    private String description;
    private String pictureLink;
    private double rating;
    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    @JsonIgnore
    private List<Wish> wish;

    public Club(String name, String address, String cityName, String description, String pictureLink, double rating) {
        this.name = name;
        this.address = address;
        this.cityName = cityName;
        this.description = description;
        this.pictureLink = pictureLink;
        this.rating = rating;
    }
}
