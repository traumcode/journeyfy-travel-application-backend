package com.journeyfy.journeyfytravelapplication.components.activities;

import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> getActivitiesByCityNameAndActivityType(String cityName, ActivityType activityType);
    List<Activity> getActivitiesByActivityType(ActivityType activityType);
    List<Activity> getActivitiesByActivityTypeAndRatingGreaterThan(ActivityType activityType, double rating);

    boolean existsByName(String name);
}
