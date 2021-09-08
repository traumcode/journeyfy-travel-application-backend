package com.journeyfy.journeyfytravelapplication.components.clubs;

import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
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
