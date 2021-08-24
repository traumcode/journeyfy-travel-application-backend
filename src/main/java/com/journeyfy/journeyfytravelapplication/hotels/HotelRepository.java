package com.journeyfy.journeyfytravelapplication.hotels;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> getHotelsByCityName(String cityName);
    List<Hotel> getHotelsByRatingGreaterThan(double rating);
}
