package com.journeyfy.journeyfytravelapplication.components.hotels;


import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import lombok.*;

import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@NoArgsConstructor
@javax.persistence.Entity
@DiscriminatorValue("hotel")
@ToString
public class Hotel extends Entity {

    public Hotel(String id, String pictureLink, String description, double rating, double price, String cityName, String name, double hotelClass, String siteLink, String address, ActivityType activityType) {
        super(id, pictureLink, description, rating, price, cityName, name, hotelClass, siteLink, address, ActivityType.MUSEUM);
    }
}