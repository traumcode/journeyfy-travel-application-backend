package com.journeyfy.journeyfytravelapplication.clubs;

import com.journeyfy.journeyfytravelapplication.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import lombok.*;

import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("club")
@javax.persistence.Entity
public class Club extends Entity {

    public Club(String pictureLink, String description, double rating, double price, String cityName, String name, String siteLink, String address, ActivityType activityType) {
        super(pictureLink, description, rating, price, cityName, name, siteLink, address, ActivityType.CLUB);
    }
}
