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
@Table(name = "activity")
@Entity
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
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts;
    @ManyToOne
    @JoinColumn(name = "wish_id")
    @JsonBackReference
    private Wish wish;
}
