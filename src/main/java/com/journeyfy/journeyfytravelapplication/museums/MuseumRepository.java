package com.journeyfy.journeyfytravelapplication.museums;
import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuseumRepository extends JpaRepository<Museum, Long> {
    List<Museum> getMuseumsByCityNameAndActivityType(String cityName, ActivityType activityType);
    List<Museum> getMuseumsByActivityTypeAndRatingGreaterThan(ActivityType activityType, double rating);
    List<Museum> getMuseumByActivityType(ActivityType activityType);
    Museum findByNameAndActivityType(String name, ActivityType activityType);


}
