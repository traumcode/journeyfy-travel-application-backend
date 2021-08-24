package com.journeyfy.journeyfytravelapplication.museums;
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
@Table(name = "museum")
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
    @ManyToOne
    @JoinColumn(name = "wish_id")
    @JsonBackReference
    private Wish wish;
    @OneToMany(mappedBy = "museum", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts;
}
