package com.journeyfy.journeyfytravelapplication.components.museums;
import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import lombok.*;

import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@NoArgsConstructor
@javax.persistence.Entity
@DiscriminatorValue("museum")
public class Museum extends Entity {

    public Museum(String pictureLink, String description, double rating, double price, String cityName, String name, String siteLink, String address, ActivityType activityType) {
        super(pictureLink, description, rating, price, cityName, name, siteLink, address, ActivityType.MUSEUM);
    }
}
