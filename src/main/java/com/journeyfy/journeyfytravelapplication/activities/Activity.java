package com.journeyfy.journeyfytravelapplication.activities;


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
@Table(name = "activity")
@Entity
public class Activity {
    @Id
    @SequenceGenerator(name = "activity_sequence", sequenceName = "activity_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_sequence")
    private Long id;
    private String pictureLink;
    private String name;
    @Column(length = 10000)
    private String description;
    private double rating;
    private double price;
    private String cityName;
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
    @JsonIgnore
    private List<Wish> wish;
}
