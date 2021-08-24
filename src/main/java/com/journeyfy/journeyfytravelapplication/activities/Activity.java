package com.journeyfy.journeyfytravelapplication.activities;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @SequenceGenerator(name = "activity_sequence", sequenceName = "activity_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_sequence")
    private Long id;
    private String pictureLink;
    private String name;
    private String description;
    private double rating;
    private double price;
    private String cityName;
    @ManyToOne
    @JoinColumn(name = "wish_id")
    @JsonBackReference
    private Wish wish;
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts;
}
