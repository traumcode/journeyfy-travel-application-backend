package com.journeyfy.journeyfytravelapplication.posts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.journeyfy.journeyfytravelapplication.activities.Activity;
import com.journeyfy.journeyfytravelapplication.clubs.Club;
import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.museums.Museum;
import com.journeyfy.journeyfytravelapplication.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @SequenceGenerator(name = "post_sequence", sequenceName = "post_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
    private Long id;
    private String title;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    private double rating;
    private LocalDateTime postedAt;
    private int likes;
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @ManyToOne
    @JoinColumn(name = "activity_id")

    private Activity activity;
    @ManyToOne
    @JoinColumn(name = "hotel_id")

    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "museum_id")

    private Museum museum;
    @ManyToOne
    @JoinColumn(name = "club_id")

    private Club club;

}
