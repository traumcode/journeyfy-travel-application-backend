package com.journeyfy.journeyfytravelapplication.components.activities;


import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="activities", produces = "application/json")
@AllArgsConstructor
public class ActivityController {
    private final ActivityRepository activityRepository;

    @GetMapping(value = "/{cityName}")
    public List<Activity> getAllActivitiesByCityName(@PathVariable("cityName") String cityName){
        return activityRepository.getActivitiesByCityNameAndActivityType(cityName, ActivityType.ACTIVITY);
    }

    @GetMapping(value = "/all-activities")
    public List<Activity> getAllActivities(){
        return activityRepository.getActivitiesByActivityType(ActivityType.ACTIVITY);
    }

    @GetMapping(value = "/top-activities")
    public List<Activity> getTopMuseums(){
        return activityRepository.getActivitiesByActivityTypeAndRatingGreaterThan(ActivityType.ACTIVITY, 4d);
    }


}
