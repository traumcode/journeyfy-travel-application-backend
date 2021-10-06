package com.journeyfy.journeyfytravelapplication.components.posts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("text")
    private String text;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("rating")
    private double rating;


    @JsonProperty("likes")
    private int likes;

    @JsonProperty("activityType")
    private String activityType;

    @JsonProperty("entityId")
    private String entityId;
}
