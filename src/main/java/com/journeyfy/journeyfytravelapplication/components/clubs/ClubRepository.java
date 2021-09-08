package com.journeyfy.journeyfytravelapplication.components.clubs;

import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> getClubsByCityNameAndActivityType(String cityName, ActivityType activityType);
    List<Club> getClubsByActivityType(ActivityType activityType);
    List<Club> getClubsByActivityTypeAndRatingGreaterThan(ActivityType activityType, double rating);

}
