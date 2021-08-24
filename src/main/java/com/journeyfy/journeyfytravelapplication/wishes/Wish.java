package com.journeyfy.journeyfytravelapplication.wishes;

import com.journeyfy.journeyfytravelapplication.activities.Activity;
import com.journeyfy.journeyfytravelapplication.clubs.Club;
import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.museums.Museum;
import com.journeyfy.journeyfytravelapplication.users.User;

import java.util.List;

public class Wish {
    private Long id;
    private String name;
    private User user;
    private List<Activity> activities;
    private List<Club> clubs;
    private List<Hotel> hotels;
    private List<Museum> museums;
}
