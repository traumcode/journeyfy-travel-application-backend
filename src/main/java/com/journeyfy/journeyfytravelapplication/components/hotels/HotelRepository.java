package com.journeyfy.journeyfytravelapplication.components.hotels;

import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> getHotelsByCityNameAndActivityType(String cityName, ActivityType activityType);
    List<Hotel> getHotelsByActivityType(ActivityType activityType);
    List<Hotel> getHotelsByActivityTypeAndRatingGreaterThan(ActivityType activityType, double rating);
    @Query(value = "SELECT * FROM hotel WHERE city_name = ?1 ORDER BY price ASC", nativeQuery = true)
    List<Hotel> getHotelsByCityNameAndOrderByPriceAsc(String cityName);
}
