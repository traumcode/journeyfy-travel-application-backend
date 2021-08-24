package com.journeyfy.journeyfytravelapplication.posts;

import com.journeyfy.journeyfytravelapplication.activities.Activity;
import com.journeyfy.journeyfytravelapplication.clubs.Club;
import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.museums.Museum;
import com.journeyfy.journeyfytravelapplication.users.User;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String title;
    private String text;
    private User user;
    private double rating;
    private LocalDateTime postedAt;
    private int likes;
    private ActivityType activityType;
//    private Activity activity;
//    private Hotel hotel;
//    private Museum museum;
//    private Club club;

}
