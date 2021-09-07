package com.journeyfy.journeyfytravelapplication.activities;


import com.journeyfy.journeyfytravelapplication.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import lombok.*;

import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@NoArgsConstructor
@javax.persistence.Entity
@DiscriminatorValue("activity")
public class Activity extends Entity {
    public Activity(String pictureLink, String description, double rating, double price, String cityName, String name, String siteLink, String address) {
        super(pictureLink, description, rating, price, cityName, name, siteLink, address, ActivityType.ACTIVITY);
    }
}
