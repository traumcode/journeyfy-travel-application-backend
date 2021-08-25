package com.journeyfy.journeyfytravelapplication.hotels;

import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> getHotelsByCityNameAndActivityType(String cityName, ActivityType activityType);
    List<Hotel> getHotelsByActivityType(ActivityType activityType);
    List<Hotel> getHotelsByActivityTypeAndRatingGreaterThan(ActivityType activityType, double rating);
}
