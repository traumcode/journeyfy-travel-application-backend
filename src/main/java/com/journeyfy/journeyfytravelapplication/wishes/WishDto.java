package com.journeyfy.journeyfytravelapplication.wishes;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.journeyfy.journeyfytravelapplication.activities.Activity;
import com.journeyfy.journeyfytravelapplication.clubs.Club;
import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.museums.Museum;
import com.journeyfy.journeyfytravelapplication.users.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private User user;

    @JsonProperty("activity_id")
    private Activity activity;

    @JsonProperty("club_id")
    private Club club;

    @JsonProperty("hotel_id")
    private Hotel hotel;

    @JsonProperty("museum_id")
    private Museum museum;


}
