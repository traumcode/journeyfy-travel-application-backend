package com.journeyfy.journeyfytravelapplication.museums;

import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuseumRepository extends JpaRepository<Museum, Long> {
    List<Museum> getMuseumsByCityName(String cityName);
    List<Museum> getMuseumsByRatingGreaterThan(double rating);
}
