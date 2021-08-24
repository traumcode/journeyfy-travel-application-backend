package com.journeyfy.journeyfytravelapplication.activities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> getActivitiesByCityName(String cityName);
    List<Activity> getActivitiesByRatingGreaterThan(double rating);
}
