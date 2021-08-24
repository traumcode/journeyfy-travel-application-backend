package com.journeyfy.journeyfytravelapplication.clubs;

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
    private String description;
    private String pictureLink;
    private double rating;
    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts;
    @ManyToOne
    @JoinColumn(name = "wish_id")
    @JsonBackReference
    private Wish wish;
}
