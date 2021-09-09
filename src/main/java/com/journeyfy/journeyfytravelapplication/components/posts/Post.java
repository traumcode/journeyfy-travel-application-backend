package com.journeyfy.journeyfytravelapplication.components.posts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
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
@javax.persistence.Entity
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
    @JoinColumn(name = "entity_id")
    private Entity entity;

    //TODO calculate rating based on review rating
}
