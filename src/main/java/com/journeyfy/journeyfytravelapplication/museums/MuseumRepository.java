package com.journeyfy.journeyfytravelapplication.museums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuseumRepository extends JpaRepository<Museum, Long> {
    List<Museum> getMuseumsByCityName(String cityName);
    List<Museum> getMuseumsByRatingGreaterThan(double rating);
    Museum findByName(String name);
}
